# Thales Client - Research & Design Document

## What is Thales?

**Thales** is named after **Thales of Miletus** (c. 624 – c. 545 BC), the first Greek philosopher and mathematician. Known as the "Father of Science," Thales sought to explain natural phenomena through reason rather than mythology.

This Minecraft client embodies Thales' spirit of:
- **Foundational Wisdom** - Building on fundamental principles
- **Rational Thinking** - Strategic gameplay enhancement
- **Innovation** - Pushing boundaries of what's possible
- **Natural Philosophy** - Understanding and mastering game mechanics

Alternative philosophical inspirations considered:
- **Euclid** - Father of Geometry, systematic and precise  
- **Aristotle** - Logic and reasoning
- **Socrates** - Questioning and wisdom
- **Pythagoras** - Mathematics and philosophy

Primary identity: **Thales - Foundational Wisdom**

## Minecraft Client Architecture Research

### Client Types

1. **Vanilla Client**: Official Minecraft client
2. **Forge Client**: Modding framework for adding mods
3. **Fabric Client**: Lightweight modding framework
4. **Hacked/Utility Clients**: Clients with gameplay enhancements

### ArMo Client Type

Thales is a **utility client** built on top of Fabric, providing:
- Performance enhancements
- Quality of life improvements
- Advanced automation features
- Resource management tools
- PvP utilities

### Technology Stack

#### Core Technologies
- **Language**: Java (Minecraft is Java-based)
- **Build Tool**: Gradle
- **Base Framework**: Fabric Loader
- **Minecraft Version**: 1.20.x (latest stable)

#### Key Dependencies
- Fabric API - Core modding API
- Mixin - For runtime code modification
- Cloth Config API - For configuration GUI
- ModMenu - For mod listing and config access

### Client Architecture Components

#### 1. Module System
- **Modules**: Individual features/hacks that can be toggled
- **Categories**: Combat, Movement, Render, Player, World, Misc
- **Module Manager**: Controls enabling/disabling modules

#### 2. Event System
- Event bus for handling game events
- Listeners for various game states
- Hook system for injecting custom logic

#### 3. Command System
- Custom command prefix (e.g., `.`)
- Command manager and parser
- Built-in commands for client control

#### 4. Configuration System
- Save/load module settings
- Per-server configurations
- JSON-based config storage

#### 5. GUI System
- ClickGUI for module management
- HUD elements for displaying info
- Custom screens and overlays

#### 6. Rendering System
- ESP (Extra Sensory Perception) rendering
- Custom overlays and indicators
- Shader integration

### Common Modules/Features

#### Combat Modules
- **Killaura**: Automatic attacking
- **Velocity**: Knockback modification
- **Criticals**: Force critical hits
- **AutoTotem**: Automatic totem placement

#### Movement Modules
- **Sprint**: Auto-sprint
- **Fly**: Flight capabilities
- **Speed**: Movement speed enhancement
- **NoFall**: Prevent fall damage

#### Render Modules
- **Fullbright**: Maximum brightness
- **ESP**: Entity highlighting
- **Tracers**: Lines to entities
- **Nametags**: Enhanced name display

#### Player Modules
- **FastBreak**: Faster block breaking
- **FastPlace**: Faster block placement
- **AutoEat**: Automatic eating
- **InvManager**: Inventory management

#### World Modules
- **Xray**: See through blocks
- **ChestESP**: Highlight chests
- **NoWeather**: Disable weather effects

#### Misc Modules
- **MiddleClick**: Various middle-click actions
- **AutoReconnect**: Auto-reconnect on disconnect
- **FakePlayer**: Spawn fake players

### Security and Ethics Considerations

⚠️ **Important Note**: This client is designed for:
- Single-player testing
- Private servers with permission
- Educational purposes

**Not for use on:**
- Public multiplayer servers without permission
- Competitive environments
- Any server where modifications are prohibited

### Development Roadmap

#### Phase 1: Foundation (Current)
- [x] Research and planning
- [ ] Project structure setup
- [ ] Basic Fabric mod skeleton
- [ ] Event system implementation
- [ ] Module system framework

#### Phase 2: Core Features
- [ ] Module manager
- [ ] Command system
- [ ] Configuration system
- [ ] Basic GUI

#### Phase 3: Module Implementation
- [ ] Essential movement modules
- [ ] Basic render modules
- [ ] Player utility modules

#### Phase 4: Enhancement
- [ ] Advanced GUI
- [ ] Additional modules
- [ ] Optimization
- [ ] Documentation

### References and Resources

#### Documentation
- Fabric Wiki: https://fabricmc.net/wiki/
- Minecraft Wiki: https://minecraft.wiki/
- Mixin Documentation: https://github.com/SpongePowered/Mixin/wiki

#### Similar Projects (for reference)
- Meteor Client (Open Source)
- Wurst Client (Open Source)
- Fabric Example Mod

#### Learning Resources
- Fabric mod development tutorials
- Mixin tutorial series
- Java game modding guides

## Technical Decisions

### Why Fabric over Forge?
- Lighter weight
- Faster updates to new Minecraft versions
- Better performance
- Modern codebase
- Mixin support built-in

### Why Java?
- Minecraft is written in Java
- Direct access to game code
- Extensive modding community
- Well-documented APIs

### Module System Design
- Modular architecture for easy feature addition
- Category-based organization
- Toggle-based system for user control
- Event-driven activation

## File Structure Plan

```
thales-client/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── thales/
│       │           ├── ThalesClient.java        # Main client class
│       │           ├── module/
│       │           │   ├── Module.java          # Base module class
│       │           │   ├── ModuleManager.java   # Module management
│       │           │   ├── Category.java        # Module categories
│       │           │   └── modules/             # Individual modules
│       │           │       ├── combat/
│       │           │       ├── movement/
│       │           │       ├── render/
│       │           │       ├── player/
│       │           │       ├── world/
│       │           │       └── misc/
│       │           ├── event/
│       │           │   ├── Event.java           # Base event class
│       │           │   ├── EventManager.java    # Event handling
│       │           │   └── events/              # Specific events
│       │           ├── command/
│       │           │   ├── Command.java         # Base command class
│       │           │   ├── CommandManager.java  # Command handling
│       │           │   └── commands/            # Individual commands
│       │           ├── gui/
│       │           │   ├── ClickGui.java        # Click GUI
│       │           │   └── hud/                 # HUD elements
│       │           ├── setting/
│       │           │   ├── Setting.java         # Base setting class
│       │           │   └── settings/            # Setting types
│       │           └── util/
│       │               └── [utility classes]
│       └── resources/
│           ├── fabric.mod.json                  # Mod metadata
│           ├── thales.mixins.json               # Mixin config
│           └── assets/
│               └── thales/
│                   ├── icon.png                 # Mod icon
│                   └── lang/
│                       └── en_us.json           # Localization
├── gradle/
│   └── wrapper/
├── build.gradle                                 # Build configuration
├── gradle.properties                            # Gradle properties
├── settings.gradle                              # Gradle settings
├── .gitignore
├── README.md
├── RESEARCH.md
└── LICENSE
```

## Next Steps

1. Set up Gradle project with Fabric
2. Create basic mod structure
3. Implement event system
4. Implement module system
5. Create first test module
6. Add basic GUI
7. Documentation and testing
