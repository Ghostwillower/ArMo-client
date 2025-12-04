package com.thales.setting;

import java.util.function.Supplier;

/**
 * Base class for module settings
 */
public abstract class Setting<T> {
    
    private final String name;
    private final String description;
    private T value;
    private final Supplier<Boolean> visibility;
    
    public Setting(String name, String description, T defaultValue) {
        this(name, description, defaultValue, () -> true);
    }
    
    public Setting(String name, String description, T defaultValue, Supplier<Boolean> visibility) {
        this.name = name;
        this.description = description;
        this.value = defaultValue;
        this.visibility = visibility;
    }
    
    /**
     * Check if this setting should be visible
     */
    public boolean isVisible() {
        return visibility.get();
    }
    
    // Getters and setters
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
}
