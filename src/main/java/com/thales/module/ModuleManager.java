package com.thales.module;

// Movement modules
import com.thales.module.modules.movement.Sprint;
import com.thales.module.modules.movement.AutoWalk;
import com.thales.module.modules.movement.AutoSneak;
import com.thales.module.modules.movement.Step;
import com.thales.module.modules.movement.NoSlow;
import com.thales.module.modules.movement.AntiVoid;
import com.thales.module.modules.movement.Scaffold;

// Render modules
import com.thales.module.modules.render.Fullbright;
import com.thales.module.modules.render.ItemESP;
import com.thales.module.modules.render.ChestESP;
import com.thales.module.modules.render.HoleESP;
import com.thales.module.modules.render.Tracers;

// Player modules
import com.thales.module.modules.player.AutoEat;
import com.thales.module.modules.player.AutoTool;
import com.thales.module.modules.player.InvManager;
import com.thales.module.modules.player.ChestStealer;

// World modules
import com.thales.module.modules.world.SafeBreak;
import com.thales.module.modules.world.AutoMine;
import com.thales.module.modules.world.NoWeather;

// Combat modules
import com.thales.module.modules.combat.AutoTotem;
import com.thales.module.modules.combat.AutoShield;

// Misc modules
import com.thales.module.modules.misc.ExampleModule;

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
        // Movement - Quality of life movement assists
        addModule(new Sprint());
        addModule(new AutoWalk());
        addModule(new AutoSneak());
        addModule(new Step());
        addModule(new NoSlow());
        addModule(new AntiVoid());
        addModule(new Scaffold());
        
        // Render - Subtle visual aids
        addModule(new Fullbright());
        addModule(new ItemESP());
        addModule(new ChestESP());
        addModule(new HoleESP());
        addModule(new Tracers());
        
        // Player - Inventory and resource management
        addModule(new AutoEat());
        addModule(new AutoTool());
        addModule(new InvManager());
        addModule(new ChestStealer());
        
        // World - Mining and building assists
        addModule(new SafeBreak());
        addModule(new AutoMine());
        addModule(new NoWeather());
        
        // Combat - Defensive assists only (no offensive)
        addModule(new AutoTotem());
        addModule(new AutoShield());
        
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
