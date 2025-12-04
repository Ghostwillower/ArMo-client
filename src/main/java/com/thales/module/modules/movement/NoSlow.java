package com.thales.module.modules.movement;

import com.thales.module.Category;
import com.thales.module.Module;

/**
 * NoSlow - Removes slowdown from using items
 * Allows normal movement speed while eating, drinking, or using items
 */
public class NoSlow extends Module {
    
    public NoSlow() {
        super("NoSlow", "No slowdown when using items", Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
    
    @Override
    public void onUpdate() {
        // Implementation would prevent the slowdown effect
        // when using items (eating, drinking, blocking, etc.)
        // This is a quality of life feature
    }
}
