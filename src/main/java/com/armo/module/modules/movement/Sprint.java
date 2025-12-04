package com.armo.module.modules.movement;

import com.armo.module.Category;
import com.armo.module.Module;

/**
 * Sprint module - Automatically sprints when moving
 */
public class Sprint extends Module {
    
    public Sprint() {
        super("Sprint", "Automatically sprint", Category.MOVEMENT);
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
        // Sprint logic will be implemented when we add mixin hooks
        // For now, this is a placeholder
    }
}
