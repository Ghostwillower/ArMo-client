package com.thales.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

/**
 * Utility class for accessing Minecraft client objects
 * Phase 2: Provides safe access to game state for modules
 */
public class MinecraftUtil {
    
    private static MinecraftClient mc = MinecraftClient.getInstance();
    
    /**
     * Get the Minecraft client instance
     */
    public static MinecraftClient getClient() {
        if (mc == null) {
            mc = MinecraftClient.getInstance();
        }
        return mc;
    }
    
    /**
     * Get the client player
     */
    public static ClientPlayerEntity getPlayer() {
        MinecraftClient client = getClient();
        return client != null ? client.player : null;
    }
    
    /**
     * Get the client world
     */
    public static ClientWorld getWorld() {
        MinecraftClient client = getClient();
        return client != null ? client.world : null;
    }
    
    /**
     * Check if player is in a world (not in menu)
     */
    public static boolean isInWorld() {
        return getPlayer() != null && getWorld() != null;
    }
    
    /**
     * Check if the game is paused
     */
    public static boolean isPaused() {
        MinecraftClient client = getClient();
        return client != null && client.isPaused();
    }
}
