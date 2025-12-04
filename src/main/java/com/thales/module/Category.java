package com.thales.module;

/**
 * Module categories for organization
 */
public enum Category {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    RENDER("Render"),
    PLAYER("Player"),
    WORLD("World"),
    MISC("Misc");
    
    private final String name;
    
    Category(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
