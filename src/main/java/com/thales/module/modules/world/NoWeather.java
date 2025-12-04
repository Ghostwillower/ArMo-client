package com.thales.module.modules.world;

import com.thales.module.Category;
import com.thales.module.Module;

/**
 * NoWeather - Removes weather effects client-side
 * Visual quality of life improvement
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
        // Implementation would:
        // 1. Set world rain strength to 0
        // 2. Set world thunder strength to 0
        // 3. Clear weather effects client-side
        
        // Visual improvement - doesn't affect gameplay
        // Just makes the game more pleasant visually
    }
}
