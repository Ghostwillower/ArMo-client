package com.thales.module.modules.render;

import com.thales.module.Category;
import com.thales.module.Module;
import com.thales.util.MinecraftUtil;
import net.minecraft.client.MinecraftClient;

/**
 * Fullbright - Maximum brightness for visibility in dark areas
 * Phase 2 Implementation Example
 * 
 * This module demonstrates gamma manipulation for fullbright effect.
 * It sets the game's gamma to maximum when enabled.
 */
public class Fullbright extends Module {
    
    private double previousGamma;
    
    public Fullbright() {
        super("Fullbright", "Maximum brightness", Category.RENDER);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        MinecraftClient mc = MinecraftUtil.getClient();
        if (mc != null && mc.options != null) {
            // Save current gamma
            previousGamma = mc.options.getGamma().getValue();
            // Set to maximum (16.0 is max in Minecraft)
            mc.options.getGamma().setValue(16.0);
        }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        MinecraftClient mc = MinecraftUtil.getClient();
        if (mc != null && mc.options != null) {
            // Restore previous gamma value
            mc.options.getGamma().setValue(previousGamma);
        }
    }
    
    @Override
    public void onUpdate() {
        // Ensure gamma stays at max while enabled
        MinecraftClient mc = MinecraftUtil.getClient();
        if (mc != null && mc.options != null) {
            if (mc.options.getGamma().getValue() < 16.0) {
                mc.options.getGamma().setValue(16.0);
            }
        }
    }
}
