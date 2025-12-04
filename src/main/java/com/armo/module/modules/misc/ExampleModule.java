package com.armo.module.modules.misc;

import com.armo.module.Category;
import com.armo.module.Module;

/**
 * Example module for testing and demonstration
 */
public class ExampleModule extends Module {
    
    public ExampleModule() {
        super("Example", "Example module for testing", Category.MISC);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("Example module enabled!");
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        System.out.println("Example module disabled!");
    }
    
    @Override
    public void onUpdate() {
        // Example update logic
    }
}
