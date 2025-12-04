package com.thales.module.modules.movement;

import com.thales.module.Category;
import com.thales.module.Module;

/**
 * Sprint - Automatically sprints when moving
 * Quality of life movement assist
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
        // Implementation would:
        // 1. Check if player is moving forward
        // 2. Check if player has enough hunger to sprint
        // 3. Automatically set sprint state
        
        // Quality of life - removes need to hold sprint key
    }
}
