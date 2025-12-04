package com.armo;

import com.armo.event.EventManager;
import com.armo.module.ModuleManager;
import com.armo.command.CommandManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ArMo Client - Advanced Resource Modification
 * Main client initialization class
 * 
 * Note: This is Phase 1 - Framework groundwork.
 * Minecraft integration will be added in Phase 2.
 */
public class ArMoClient {
    
    public static final String MOD_ID = "armo";
    public static final String MOD_NAME = "ArMo Client";
    public static final String VERSION = "0.1.0-ALPHA";
    
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    
    private static ArMoClient INSTANCE;
    
    private ModuleManager moduleManager;
    private EventManager eventManager;
    private CommandManager commandManager;
    
    /**
     * Initialize the client
     */
    public void initialize() {
        INSTANCE = this;
        
        LOGGER.info("Initializing {} v{}", MOD_NAME, VERSION);
        LOGGER.info("Advanced Resource Modification - Loading...");
        
        // Initialize core systems
        initializeSystems();
        
        LOGGER.info("{} successfully loaded!", MOD_NAME);
    }
    
    /**
     * Initialize all core client systems
     */
    private void initializeSystems() {
        LOGGER.info("Initializing core systems...");
        
        // Event system - must be first
        eventManager = new EventManager();
        LOGGER.info("Event system initialized");
        
        // Module system
        moduleManager = new ModuleManager();
        LOGGER.info("Module system initialized with {} modules", 
            moduleManager.getModuleCount());
        
        // Command system
        commandManager = new CommandManager();
        LOGGER.info("Command system initialized");
        
        LOGGER.info("All core systems initialized successfully");
    }
    
    /**
     * Get the singleton instance of ArMoClient
     */
    public static ArMoClient getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ArMoClient();
            INSTANCE.initialize();
        }
        return INSTANCE;
    }
    
    /**
     * Get the module manager
     */
    public ModuleManager getModuleManager() {
        return moduleManager;
    }
    
    /**
     * Get the event manager
     */
    public EventManager getEventManager() {
        return eventManager;
    }
    
    /**
     * Get the command manager
     */
    public CommandManager getCommandManager() {
        return commandManager;
    }
    
    /**
     * Main method for demonstration purposes
     */
    public static void main(String[] args) {
        String separator = "==================================================";
        LOGGER.info(separator);
        LOGGER.info("ArMo Client - Advanced Resource Modification");
        LOGGER.info("Phase 1: Framework Groundwork");
        LOGGER.info(separator);
        
        // Initialize the client
        ArMoClient client = ArMoClient.getInstance();
        
        // Demonstrate module system
        LOGGER.info("\n--- Module System Demo ---");
        LOGGER.info("Total modules: {}", client.getModuleManager().getModuleCount());
        client.getModuleManager().getModules().forEach(module -> 
            LOGGER.info("  - {} ({}): {}", 
                module.getName(), 
                module.getCategory().getName(), 
                module.getDescription())
        );
        
        // Demonstrate command system
        LOGGER.info("\n--- Command System Demo ---");
        LOGGER.info("Command prefix: {}", CommandManager.PREFIX);
        LOGGER.info("Available commands:");
        client.getCommandManager().getCommands().forEach(command ->
            LOGGER.info("  - {}: {}", command.getName(), command.getDescription())
        );
        
        LOGGER.info("\n{}", separator);
        LOGGER.info("Framework initialization complete!");
        LOGGER.info("Ready for Phase 2: Minecraft integration");
        LOGGER.info(separator);
    }
}
