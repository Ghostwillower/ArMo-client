package com.thales.module.modules.world;

import com.thales.module.Category;
import com.thales.module.Module;
import com.thales.util.MinecraftUtil;

/**
 * NoWeather - Removes weather effects client-side
 * Visual quality of life improvement
 * 
 * Implementation based on Meteor client's NoRender module.
 * Clears weather effects for better visibility.
 */
public class NoWeather extends Module {
    
    public NoWeather() {
        super("NoWeather", "Remove weather effects", Category.WORLD);
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
        
        // Phase 2 implementation:
        // ClientWorld world = MinecraftUtil.getWorld();
        // if (world == null) return;
        // 
        // // Set rain and thunder to 0 client-side
        // world.setRainGradient(0.0f);
        // world.setThunderGradient(0.0f);
        // 
        // // This is client-side only and doesn't affect gameplay
        // // Just makes the game more pleasant visually
        
        // Visual improvement - doesn't affect gameplay
        // Improves visibility during storms
    }
}
