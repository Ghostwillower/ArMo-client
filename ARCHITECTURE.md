# ArMo Client Architecture

## Overview

ArMo Client is built on a modular architecture using the Fabric modding framework for Minecraft. This document outlines the architectural decisions and structure of the client.

## Core Principles

1. **Modularity**: Features are implemented as independent modules
2. **Event-Driven**: Systems communicate through an event bus
3. **Extensibility**: Easy to add new modules and features
4. **Performance**: Minimal impact on game performance
5. **Safety**: Designed for educational and authorized use only

## System Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                     ArMo Client                             │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  ┌────────────────┐  ┌────────────────┐  ┌──────────────┐  │
│  │ Module System  │  │ Event System   │  │ Command Sys  │  │
│  │                │  │                │  │              │  │
│  │ - Module Mgr   │  │ - Event Bus    │  │ - Commands   │  │
│  │ - Categories   │  │ - Listeners    │  │ - Prefix     │  │
│  │ - Settings     │  │ - Events       │  │              │  │
│  └────────────────┘  └────────────────┘  └──────────────┘  │
│                                                              │
│  ┌────────────────┐  ┌────────────────┐  ┌──────────────┐  │
│  │ GUI System     │  │ Config System  │  │ Utilities    │  │
│  │ (Future)       │  │ (Future)       │  │              │  │
│  └────────────────┘  └────────────────┘  └──────────────┘  │
│                                                              │
├─────────────────────────────────────────────────────────────┤
│                     Mixin Layer                             │
│  - Hooks into Minecraft code at runtime                     │
│  - Injects custom logic into game methods                   │
├─────────────────────────────────────────────────────────────┤
│                   Fabric Framework                          │
│  - Fabric Loader    - Fabric API    - Mixin                 │
├─────────────────────────────────────────────────────────────┤
│                   Minecraft 1.20.1                          │
└─────────────────────────────────────────────────────────────┘
```

## Component Details

### 1. Module System

#### Module
- **Purpose**: Represents a single feature/hack
- **Location**: `com.armo.module.Module`
- **Key Methods**:
  - `onEnable()`: Called when module is turned on
  - `onDisable()`: Called when module is turned off
  - `onUpdate()`: Called every game tick when enabled
  - `toggle()`: Switch between enabled/disabled

#### ModuleManager
- **Purpose**: Manages all modules in the client
- **Location**: `com.armo.module.ModuleManager`
- **Responsibilities**:
  - Register all modules
  - Enable/disable modules
  - Provide module lookup by name or class
  - Update all enabled modules each tick

#### Category
- **Purpose**: Organize modules into logical groups
- **Location**: `com.armo.module.Category`
- **Categories**:
  - Combat: PvP-related features
  - Movement: Movement enhancements
  - Render: Visual features
  - Player: Player utilities
  - World: World interaction
  - Misc: Miscellaneous features

### 2. Event System

#### Event
- **Purpose**: Base class for all events
- **Location**: `com.armo.event.Event`
- **Features**:
  - Cancellable events
  - Type-safe event handling

#### EventManager
- **Purpose**: Event bus for publish-subscribe pattern
- **Location**: `com.armo.event.EventManager`
- **Features**:
  - Register/unregister listeners
  - Post events to all listeners
  - Reflection-based method invocation

#### EventHandler
- **Purpose**: Annotation to mark event listener methods
- **Location**: `com.armo.event.EventHandler`
- **Usage**:
```java
@EventHandler
public void onTick(TickEvent event) {
    // Handle tick event
}
```

### 3. Command System

#### Command
- **Purpose**: Base class for all commands
- **Location**: `com.armo.command.Command`
- **Features**:
  - Name and aliases
  - Execute method
  - Usage information

#### CommandManager
- **Purpose**: Manages command execution
- **Location**: `com.armo.command.CommandManager`
- **Features**:
  - Command prefix (default: `.`)
  - Parse and execute commands
  - Command registration

### 4. Setting System

#### Setting
- **Purpose**: Configuration option for modules
- **Location**: `com.armo.setting.Setting`
- **Features**:
  - Generic type support
  - Conditional visibility
  - Default values

### 5. Mixin Layer

#### MixinMinecraftClient
- **Purpose**: Hook into Minecraft's tick method
- **Location**: `com.armo.mixin.MixinMinecraftClient`
- **Functionality**:
  - Injects into `MinecraftClient.tick()`
  - Updates all enabled modules

### 6. Utilities

#### ClientUtil
- **Purpose**: Helper methods for accessing Minecraft objects
- **Location**: `com.armo.util.ClientUtil`
- **Methods**:
  - `getClient()`: Get MinecraftClient instance
  - `getPlayer()`: Get player entity
  - `getWorld()`: Get client world
  - `isInWorld()`: Check if in world

## Data Flow

### Module Execution Flow
```
Game Tick → MixinMinecraftClient.onTick()
          → ModuleManager.onUpdate()
          → For each enabled Module:
              → Module.onUpdate()
```

### Event Flow
```
Game Event → Mixin Hook
           → EventManager.post(event)
           → For each registered listener:
               → Listener method invoked
```

### Command Flow
```
Chat Input → CommandManager.executeCommand()
           → Parse command and args
           → Find matching Command
           → Command.execute(args)
```

## Module Development

### Creating a New Module

1. Extend the `Module` class
2. Implement constructor with name, description, category
3. Override `onEnable()`, `onDisable()`, `onUpdate()` as needed
4. Register in `ModuleManager.registerModules()`

Example:
```java
public class ExampleModule extends Module {
    public ExampleModule() {
        super("Example", "Example module", Category.MISC);
    }
    
    @Override
    public void onEnable() {
        // Module enabled
    }
    
    @Override
    public void onUpdate() {
        // Called every tick
    }
}
```

### Adding Settings to a Module

```java
public class ExampleModule extends Module {
    private Setting<Boolean> enabled;
    
    public ExampleModule() {
        super("Example", "Example module", Category.MISC);
        addSetting(enabled = new BooleanSetting("Enabled", "Enable feature", true));
    }
    
    @Override
    public void onUpdate() {
        if (enabled.getValue()) {
            // Do something
        }
    }
}
```

## Build Process

### Gradle Build Flow
```
gradle build → Compile Java sources
            → Process resources
            → Apply Fabric transformations
            → Generate mod JAR
            → Output to build/libs/
```

### Output
- Main JAR: `armo-client-{version}.jar`
- Sources JAR: `armo-client-{version}-sources.jar`

## Dependencies

### Core Dependencies
- **Minecraft**: 1.20.1
- **Fabric Loader**: 0.15.0+
- **Fabric API**: 0.91.0+
- **Java**: 17+

### Development Dependencies
- **Yarn Mappings**: For deobfuscated Minecraft code
- **Mixin**: For runtime code modification
- **SLF4J**: Logging framework

## File Structure

```
ArMo-client/
├── src/main/
│   ├── java/com/armo/
│   │   ├── ArMoClient.java          # Main entry point
│   │   ├── module/                   # Module system
│   │   │   ├── Module.java
│   │   │   ├── ModuleManager.java
│   │   │   ├── Category.java
│   │   │   └── modules/              # Individual modules
│   │   │       ├── combat/
│   │   │       ├── movement/
│   │   │       ├── render/
│   │   │       ├── player/
│   │   │       ├── world/
│   │   │       └── misc/
│   │   ├── event/                    # Event system
│   │   │   ├── Event.java
│   │   │   ├── EventManager.java
│   │   │   ├── EventHandler.java
│   │   │   └── events/
│   │   ├── command/                  # Command system
│   │   │   ├── Command.java
│   │   │   ├── CommandManager.java
│   │   │   └── commands/
│   │   ├── setting/                  # Settings
│   │   │   └── Setting.java
│   │   ├── util/                     # Utilities
│   │   │   └── ClientUtil.java
│   │   └── mixin/                    # Mixins
│   │       └── MixinMinecraftClient.java
│   └── resources/
│       ├── fabric.mod.json           # Mod metadata
│       ├── armo.mixins.json          # Mixin config
│       └── assets/armo/
│           └── lang/en_us.json       # Localization
├── build.gradle                      # Build config
├── gradle.properties                 # Properties
└── settings.gradle                   # Settings
```

## Future Enhancements

### Phase 2: Core Features
- Configuration system (save/load settings)
- More events (render, packet, etc.)
- GUI framework (ClickGUI, HUD)

### Phase 3: Advanced Modules
- Combat modules (Killaura, Velocity, etc.)
- Movement modules (Fly, Speed, etc.)
- Render modules (ESP, Tracers, etc.)

### Phase 4: Polish
- Advanced GUI
- Keybind system
- Profile system
- Optimization

## Security Considerations

### Best Practices
- No hardcoded server IPs
- No automatic griefing features
- Clear warnings about usage
- Respects server rules

### Ethical Use
- Educational purposes
- Private servers only
- With explicit permission
- Not for competitive advantage

## Performance Optimization

### Current Optimizations
- Modules only update when enabled
- Event system uses efficient registration
- Minimal object allocation in hot paths

### Future Optimizations
- Caching frequently accessed data
- Batch rendering operations
- Async operations where possible

## Testing Strategy

### Manual Testing
- Test in single-player
- Test module enable/disable
- Test command execution
- Verify no crashes

### Future Automated Testing
- Unit tests for core systems
- Integration tests for modules
- Performance benchmarks

## Contributing Guidelines

### Code Style
- Follow existing patterns
- Use meaningful variable names
- Add comments for complex logic
- Keep methods focused and small

### Adding Modules
1. Create module class in appropriate category package
2. Implement required methods
3. Register in ModuleManager
4. Test thoroughly

### Adding Commands
1. Extend Command class
2. Implement execute() and getUsage()
3. Register in CommandManager
4. Add to help documentation

## Resources

- [Fabric Wiki](https://fabricmc.net/wiki/)
- [Mixin Documentation](https://github.com/SpongePowered/Mixin/wiki)
- [Minecraft Wiki](https://minecraft.wiki/)
