package com.thales.module.modules.movement;

import com.thales.module.Category;
import com.thales.module.Module;
import com.thales.util.MinecraftUtil;

/**
 * Step - Increases step height for easier movement
 * Allows stepping up full blocks without jumping
 * 
 * Implementation based on Meteor client's Step module.
 * Modifies player step height attribute for smooth traversal.
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
        // Phase 2 implementation:
        // ClientPlayerEntity player = MinecraftUtil.getPlayer();
        // if (player != null) {
        //     player.setStepHeight(ENHANCED_STEP_HEIGHT);
        // }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        // Reset step height to normal
        // Phase 2 implementation:
        // ClientPlayerEntity player = MinecraftUtil.getPlayer();
        // if (player != null) {
        //     player.setStepHeight(NORMAL_STEP_HEIGHT);
        // }
    }
    
    @Override
    public void onUpdate() {
        // Step height is set in onEnable, no per-tick logic needed
        // Phase 2: Could add dynamic step height based on conditions
        if (!MinecraftUtil.isInWorld()) {
            return;
        }
    }
}
