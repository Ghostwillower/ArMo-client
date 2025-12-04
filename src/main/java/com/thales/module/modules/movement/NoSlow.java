package com.thales.module.modules.movement;

import com.thales.module.Category;
import com.thales.module.Module;
import com.thales.util.MinecraftUtil;

/**
 * NoSlow - Removes slowdown from using items
 * Allows normal movement speed while eating, drinking, or using items
 * 
 * Implementation based on Meteor client's NoSlow module.
 * Uses mixin to bypass item use slowdown in player movement.
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
        if (!MinecraftUtil.isInWorld()) {
            return;
        }
        
        // Phase 2 implementation with Mixin:
        // This module works through mixin injection into
        // ClientPlayerEntity.tickMovement() to bypass slowdown
        // 
        // @Inject in ClientPlayerEntityMixin:
        // if (ModuleManager.getModule(NoSlow.class).isEnabled()) {
        //     // Skip the item use slowdown logic
        //     // Maintains full movement speed while using items
        // }
        // 
        // Quality of life - removes annoying slowdown
    }
}
