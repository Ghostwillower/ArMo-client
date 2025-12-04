package com.thales.module;

import com.thales.setting.Setting;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all modules
 */
public abstract class Module {
    
    private final String name;
    private final String description;
    private final Category category;
    private final List<Setting<?>> settings;
    
    private boolean enabled;
    private int keyCode;
    
    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.settings = new ArrayList<>();
        this.enabled = false;
        this.keyCode = -1;
    }
    
    /**
     * Called when the module is enabled
     */
    public void onEnable() {
        // Override in subclasses
    }
    
    /**
     * Called when the module is disabled
     */
    public void onDisable() {
        // Override in subclasses
    }
    
    /**
     * Called every tick when the module is enabled
     */
    public void onUpdate() {
        // Override in subclasses
    }
    
    /**
     * Toggle the module on/off
     */
    public void toggle() {
        setEnabled(!enabled);
    }
    
    /**
     * Set the enabled state of the module
     */
    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) return;
        
        this.enabled = enabled;
        
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }
    
    /**
     * Add a setting to this module
     */
    protected void addSetting(Setting<?> setting) {
        settings.add(setting);
    }
    
    // Getters
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public int getKeyCode() {
        return keyCode;
    }
    
    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }
    
    public List<Setting<?>> getSettings() {
        return settings;
    }
}
