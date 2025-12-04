package com.thales.module.modules.render;

import com.thales.module.Category;
import com.thales.module.Module;

/**
 * Fullbright module - Maximum brightness
 */
public class Fullbright extends Module {
    
    public Fullbright() {
        super("Fullbright", "Maximum brightness", Category.RENDER);
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
        // Fullbright logic will be implemented when we add mixin hooks
        // For now, this is a placeholder
    }
}
