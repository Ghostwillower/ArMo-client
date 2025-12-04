package com.thales.command;

import com.thales.ThalesClient;
import com.thales.command.commands.HelpCommand;
import com.thales.command.commands.ToggleCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages all client commands
 */
public class CommandManager {
    
    public static final String PREFIX = ".";
    
    private final List<Command> commands;
    
    public CommandManager() {
        commands = new ArrayList<>();
        
        // Register all commands
        registerCommands();
    }
    
    /**
     * Register all available commands
     */
    private void registerCommands() {
        addCommand(new HelpCommand());
        addCommand(new ToggleCommand());
    }
    
    /**
     * Add a command to the manager
     */
    private void addCommand(Command command) {
        commands.add(command);
    }
    
    /**
     * Execute a command from a chat message
     * @param message The chat message
     * @return true if a command was executed
     */
    public boolean executeCommand(String message) {
        if (!message.startsWith(PREFIX)) return false;
        
        String commandString = message.substring(PREFIX.length());
        String[] parts = commandString.split(" ");
        String commandName = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);
        
        for (Command command : commands) {
            if (command.matches(commandName)) {
                try {
                    command.execute(args);
                    return true;
                } catch (Exception e) {
                    ThalesClient.LOGGER.error("Error executing command {}: {}", 
                        commandName, e.getMessage(), e);
                }
            }
        }
        
        ThalesClient.LOGGER.warn("Unknown command. Type {}help for a list of commands.", PREFIX);
        return true;
    }
    
    /**
     * Get all commands
     */
    public List<Command> getCommands() {
        return commands;
    }
}
