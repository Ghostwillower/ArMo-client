package com.armo.command.commands;

import com.armo.ArMoClient;
import com.armo.command.Command;

/**
 * Help command - Lists all available commands
 */
public class HelpCommand extends Command {
    
    public HelpCommand() {
        super("help", "Lists all available commands", "h", "?");
    }
    
    @Override
    public void execute(String[] args) {
        System.out.println("=== ArMo Client Commands ===");
        
        for (Command command : ArMoClient.getInstance().getCommandManager().getCommands()) {
            System.out.println(command.getName() + " - " + command.getDescription());
            System.out.println("  Usage: " + command.getUsage());
        }
    }
    
    @Override
    public String getUsage() {
        return ".help";
    }
}
