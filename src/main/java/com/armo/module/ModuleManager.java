package com.armo.module;

import com.armo.module.modules.movement.Sprint;
import com.armo.module.modules.render.Fullbright;
import com.armo.module.modules.misc.ExampleModule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages all client modules
 */
public class ModuleManager {
    
    private final List<Module> modules;
    
    public ModuleManager() {
        modules = new ArrayList<>();
        
        // Register all modules
        registerModules();
    }
    
    /**
     * Register all available modules
     */
    private void registerModules() {
        // Movement
        addModule(new Sprint());
        
        // Render
        addModule(new Fullbright());
        
        // Misc
        addModule(new ExampleModule());
    }
    
    /**
     * Add a module to the manager
     */
    private void addModule(Module module) {
        modules.add(module);
    }
    
    /**
     * Get a module by name
     */
    public Module getModule(String name) {
        return modules.stream()
            .filter(m -> m.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Get a module by class
     */
    public <T extends Module> T getModule(Class<T> clazz) {
        for (Module module : modules) {
            if (clazz.isInstance(module)) {
                return clazz.cast(module);
            }
        }
        return null;
    }
    
    /**
     * Get all modules in a category
     */
    public List<Module> getModulesByCategory(Category category) {
        return modules.stream()
            .filter(m -> m.getCategory() == category)
            .collect(Collectors.toList());
    }
    
    /**
     * Get all modules
     */
    public List<Module> getModules() {
        return modules;
    }
    
    /**
     * Get all enabled modules
     */
    public List<Module> getEnabledModules() {
        return modules.stream()
            .filter(Module::isEnabled)
            .collect(Collectors.toList());
    }
    
    /**
     * Get the total number of modules
     */
    public int getModuleCount() {
        return modules.size();
    }
    
    /**
     * Called every tick to update all enabled modules
     */
    public void onUpdate() {
        for (Module module : getEnabledModules()) {
            module.onUpdate();
        }
    }
}
