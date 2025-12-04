package com.armo.event;

import com.armo.ArMoClient;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Event manager - handles event registration and posting
 */
public class EventManager {
    
    private final Map<Class<? extends Event>, List<EventListener>> listeners;
    
    public EventManager() {
        this.listeners = new ConcurrentHashMap<>();
    }
    
    /**
     * Register an object to receive events
     */
    public void register(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventHandler.class)) {
                Class<?>[] parameters = method.getParameterTypes();
                if (parameters.length == 1 && Event.class.isAssignableFrom(parameters[0])) {
                    @SuppressWarnings("unchecked")
                    Class<? extends Event> eventClass = (Class<? extends Event>) parameters[0];
                    
                    EventListener listener = new EventListener(object, method);
                    listeners.computeIfAbsent(eventClass, k -> new ArrayList<>()).add(listener);
                }
            }
        }
    }
    
    /**
     * Unregister an object from receiving events
     */
    public void unregister(Object object) {
        listeners.values().forEach(list -> 
            list.removeIf(listener -> listener.getObject() == object)
        );
    }
    
    /**
     * Post an event to all registered listeners
     */
    public void post(Event event) {
        List<EventListener> eventListeners = listeners.get(event.getClass());
        if (eventListeners != null) {
            for (EventListener listener : eventListeners) {
                listener.invoke(event);
            }
        }
    }
    
    /**
     * Wrapper for event listener methods
     */
    private static class EventListener {
        private final Object object;
        private final Method method;
        
        public EventListener(Object object, Method method) {
            this.object = object;
            this.method = method;
            method.setAccessible(true);
        }
        
        public void invoke(Event event) {
            try {
                method.invoke(object, event);
            } catch (Exception e) {
                ArMoClient.LOGGER.error("Error invoking event handler {} for event {}", 
                    method.getName(), 
                    event.getClass().getSimpleName(), 
                    e);
            }
        }
        
        public Object getObject() {
            return object;
        }
    }
}
