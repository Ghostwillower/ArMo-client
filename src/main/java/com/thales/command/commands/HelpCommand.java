package com.thales.command.commands;

import com.thales.ThalesClient;
import com.thales.command.Command;

/**
 * Help command - Lists all available commands
 */
public class HelpCommand extends Command {
    
    public HelpCommand() {
        super("help", "Lists all available commands", "h", "?");
    }
    
    @Override
    public void execute(String[] args) {
        System.out.println("=== Thales Client Commands ===");
        
        for (Command command : ThalesClient.getInstance().getCommandManager().getCommands()) {
            System.out.println(command.getName() + " - " + command.getDescription());
            System.out.println("  Usage: " + command.getUsage());
        }
    }
    
    @Override
    public String getUsage() {
        return ".help";
    }
}
