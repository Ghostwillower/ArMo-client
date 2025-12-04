package com.thales.module.modules.movement;

import com.thales.module.Category;
import com.thales.module.Module;
import com.thales.util.MinecraftUtil;
import net.minecraft.client.network.ClientPlayerEntity;

/**
 * Sprint - Automatically sprints when moving forward
 * Phase 2 Implementation Example
 * 
 * This module demonstrates full Minecraft API integration.
 * It automatically enables sprinting when the player moves forward.
 */
public class Sprint extends Module {
    
    public Sprint() {
        super("Sprint", "Automatically sprint when moving", Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        // Stop sprinting when module is disabled
        ClientPlayerEntity player = MinecraftUtil.getPlayer();
        if (player != null) {
            player.setSprinting(false);
        }
    }
    
    @Override
    public void onUpdate() {
        // Check if player is in a world
        if (!MinecraftUtil.isInWorld()) {
            return;
        }
        
        ClientPlayerEntity player = MinecraftUtil.getPlayer();
        if (player == null) {
            return;
        }
        
        // Check conditions for sprinting
        boolean isMovingForward = player.input.movementForward > 0;
        boolean hasEnoughHunger = player.getHungerManager().getFoodLevel() > 6;
        boolean canSprint = !player.isSneaking() && !player.isSubmergedInWater();
        
        // Enable sprinting if all conditions are met
        if (isMovingForward && hasEnoughHunger && canSprint) {
            player.setSprinting(true);
        }
    }
}
