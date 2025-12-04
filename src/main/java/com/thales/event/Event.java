package com.thales.event;

/**
 * Base class for all events
 */
public abstract class Event {
    
    private boolean cancelled;
    
    public Event() {
        this.cancelled = false;
    }
    
    /**
     * Check if this event is cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }
    
    /**
     * Set the cancelled state of this event
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
    
    /**
     * Cancel this event
     */
    public void cancel() {
        setCancelled(true);
    }
}
