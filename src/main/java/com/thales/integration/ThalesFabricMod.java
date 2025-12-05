package com.thales.integration;

import com.thales.ThalesClient;
import com.thales.event.EventManager;
import com.thales.module.ModuleManager;
import com.thales.command.CommandManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thales Client - Fabric Mod Entry Point
 * Phase 2: Minecraft Integration
 * 
 * This class is called by Fabric Loader when the client starts.
 * It initializes the Thales Client and all its systems.
 */
public class ThalesFabricMod implements ClientModInitializer {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(ThalesClient.MOD_NAME);
    
    private static ThalesFabricMod INSTANCE;
    private ThalesClient client;
    
    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        
        LOGGER.info("==================================================");
        LOGGER.info("{} - Phase 2: Minecraft Integration", ThalesClient.MOD_NAME);
        LOGGER.info("==================================================");
        LOGGER.info("Initializing {} v{}", ThalesClient.MOD_NAME, ThalesClient.VERSION);
        LOGGER.info("Under the Radar Assist Client - Loading...");
        
        // Initialize the core client
        client = ThalesClient.getInstance();
        
        LOGGER.info("{} successfully loaded!", ThalesClient.MOD_NAME);
        LOGGER.info("Total modules: {}", client.getModuleManager().getModuleCount());
        LOGGER.info("Modules ready for Minecraft integration");
        LOGGER.info("==================================================");
    }
    
    public static ThalesFabricMod getInstance() {
        return INSTANCE;
    }
    
    public ThalesClient getClient() {
        return client;
    }
    
    public ModuleManager getModuleManager() {
        return client.getModuleManager();
    }
    
    public EventManager getEventManager() {
        return client.getEventManager();
    }
    
    public CommandManager getCommandManager() {
        return client.getCommandManager();
    }
}
