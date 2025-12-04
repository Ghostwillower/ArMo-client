package com.armo.command.commands;

import com.armo.ArMoClient;
import com.armo.command.Command;
import com.armo.module.Module;

/**
 * Toggle command - Toggle modules on/off
 */
public class ToggleCommand extends Command {
    
    public ToggleCommand() {
        super("toggle", "Toggle a module on or off", "t");
    }
    
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: " + getUsage());
            return;
        }
        
        String moduleName = args[0];
        Module module = ArMoClient.getInstance().getModuleManager().getModule(moduleName);
        
        if (module == null) {
            System.out.println("Module '" + moduleName + "' not found!");
            return;
        }
        
        module.toggle();
        System.out.println(module.getName() + " " + (module.isEnabled() ? "enabled" : "disabled"));
    }
    
    @Override
    public String getUsage() {
        return ".toggle <module>";
    }
}
