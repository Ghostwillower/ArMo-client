package com.thales.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple logger implementation to avoid external dependencies
 */
public class SimpleLogger {
    
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final String name;
    
    public SimpleLogger(String name) {
        this.name = name;
    }
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void info(String format, Object... args) {
        log("INFO", formatMessage(format, args));
    }
    
    public void warn(String message) {
        log("WARN", message);
    }
    
    public void warn(String format, Object... args) {
        log("WARN", formatMessage(format, args));
    }
    
    public void error(String message) {
        log("ERROR", message);
    }
    
    public void error(String format, Object... args) {
        log("ERROR", formatMessage(format, args));
    }
    
    public void debug(String message) {
        log("DEBUG", message);
    }
    
    public void debug(String format, Object... args) {
        log("DEBUG", formatMessage(format, args));
    }
    
    private String formatMessage(String format, Object... args) {
        return String.format(format.replace("{}", "%s"), args);
    }
    
    private void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(TIME_FORMAT);
        System.out.println(String.format("[%s] [%s/%s] %s", timestamp, name, level, message));
    }
}
