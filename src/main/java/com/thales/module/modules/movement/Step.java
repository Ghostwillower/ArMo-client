package com.thales.module.modules.movement;

import com.thales.module.Category;
import com.thales.module.Module;

/**
 * Step - Increases step height for easier movement
 * Allows stepping up full blocks without jumping
 */
public class Step extends Module {
    
    private static final float NORMAL_STEP_HEIGHT = 0.6f;
    private static final float ENHANCED_STEP_HEIGHT = 1.0f;
    
    public Step() {
        super("Step", "Step up full blocks", Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        // Would set player step height to 1.0 (full block)
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        // Would reset player step height to 0.6 (default)
    }
    
    @Override
    public void onUpdate() {
        // Step height is set in onEnable, no per-tick logic needed
    }
}
