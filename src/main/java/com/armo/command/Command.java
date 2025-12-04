package com.armo.command;

/**
 * Base class for all commands
 */
public abstract class Command {
    
    private final String name;
    private final String description;
    private final String[] aliases;
    
    public Command(String name, String description, String... aliases) {
        this.name = name;
        this.description = description;
        this.aliases = aliases;
    }
    
    /**
     * Execute the command
     * @param args Command arguments
     */
    public abstract void execute(String[] args);
    
    /**
     * Get command usage information
     */
    public abstract String getUsage();
    
    /**
     * Check if this command matches the given name
     */
    public boolean matches(String input) {
        if (name.equalsIgnoreCase(input)) return true;
        for (String alias : aliases) {
            if (alias.equalsIgnoreCase(input)) return true;
        }
        return false;
    }
    
    // Getters
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String[] getAliases() {
        return aliases;
    }
}
