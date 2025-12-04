package com.thales.module.modules.render;

import com.thales.module.Category;
import com.thales.module.Module;
import com.thales.util.MinecraftUtil;

/**
 * Fullbright - Maximum brightness for visibility in dark areas
 * Sets gamma to maximum value
 * 
 * Implementation based on Meteor client's Fullbright module.
 * Manipulates the gamma setting for full brightness.
 */
public class Fullbright extends Module {
    
    private double previousGamma = 1.0;
    private static final double MAX_GAMMA = 16.0;
    
    public Fullbright() {
        super("Fullbright", "Maximum brightness", Category.RENDER);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        // Phase 2 implementation:
        // MinecraftClient mc = MinecraftUtil.getClient();
        // if (mc != null && mc.options != null) {
        //     // Save current gamma
        //     previousGamma = mc.options.getGamma().getValue();
        //     // Set to maximum (16.0 is max in Minecraft)
        //     mc.options.getGamma().setValue(MAX_GAMMA);
        // }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        // Phase 2 implementation:
        // MinecraftClient mc = MinecraftUtil.getClient();
        // if (mc != null && mc.options != null) {
        //     // Restore previous gamma value
        //     mc.options.getGamma().setValue(previousGamma);
        // }
    }
    
    @Override
    public void onUpdate() {
        // Ensure gamma stays at max while enabled
        // Phase 2 implementation:
        // MinecraftClient mc = MinecraftUtil.getClient();
        // if (mc != null && mc.options != null) {
        //     if (mc.options.getGamma().getValue() < MAX_GAMMA) {
        //         mc.options.getGamma().setValue(MAX_GAMMA);
        //     }
        // }
    }
}
