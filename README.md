# Thales Client - Under the Radar Assist Client

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Minecraft](https://img.shields.io/badge/minecraft-1.20.x-green.svg)
![Status](https://img.shields.io/badge/status-in%20development-yellow.svg)

**Thales** is an "under the radar" Minecraft assist client built on Fabric, designed to provide subtle quality-of-life enhancements, intelligent automation via Baritone, and helpful visual aids. Unlike aggressive hacking clients, Thales focuses on assistance rather than unfair advantages.

Named after Thales of Miletus, the first Greek philosopher, this client embodies wisdom and subtle intelligence in gameplay enhancement.

## ⚠️ Disclaimer

This client is intended for:
- ✅ Single-player use
- ✅ Private servers with explicit permission
- ✅ Educational and research purposes

**DO NOT** use on:
- ❌ Public multiplayer servers without permission
- ❌ Competitive environments where modifications are prohibited
- ❌ Any server where such modifications violate rules

**Users are responsible for complying with server rules and terms of service.**

## 🎯 What is Thales?

**Thales** is an **"under the radar" assist client** that provides helpful gameplay enhancements without being obvious or aggressive. Key philosophy:

- 🤝 **Quality of Life**: Automate tedium, not gameplay
- 🎯 **Subtle Assistance**: Visual aids that help, not cheat
- 🛡️ **Safety First**: Defensive features prioritized over offensive
- 🧭 **Baritone Integration**: Intelligent pathfinding and automation
- 🎮 **Skill Enhancement**: Assists skilled play, doesn't replace it

Unlike traditional "hacked clients," Thales focuses on:
- ✅ Resource management and organization
- ✅ Movement quality of life improvements  
- ✅ Subtle visual information overlays
- ✅ Automation of repetitive tasks
- ✅ Safety and fall prevention
- ❌ **NOT** aggressive PvP features
- ❌ **NOT** obvious cheating (kill aura, fly, etc.)
- ❌ **NOT** designed for griefing

## ✨ Features

### 🏃 Movement (Quality of Life)
- **Sprint** - Auto-sprint functionality
- **AutoWalk** - Baritone-powered intelligent pathfinding
- **AutoSneak** - Context-aware edge detection
- **Step** - Improved step height for easier traversal
- **NoSlow** - Remove slowdown from using items
- **AntiVoid** - Void fall protection
- **Scaffold** - Safe bridging and building assistance

### 👁️ Render (Subtle Visual Aids)
- **Fullbright** - Maximum visibility in dark areas
- **ItemESP** - Highlight dropped items
- **ChestESP** - Locate storage containers
- **HoleESP** - Find safe 1x1 holes
- **Tracers** - Configurable entity tracking lines

### 👤 Player (Resource Management)
- **AutoEat** - Automatic hunger management
- **AutoTool** - Smart tool selection for mining
- **InvManager** - Intelligent inventory sorting
- **ChestStealer** - Rapid chest looting

### 🌍 World (Building & Mining Assists)
- **SafeBreak** - Prevents dangerous block breaking
- **AutoMine** - Baritone-powered ore mining
- **NoWeather** - Client-side weather removal

### 🛡️ Combat (Defensive Only)
- **AutoTotem** - Automatic totem management
- **AutoShield** - Defensive shield raising

### ⚠️ What We DON'T Include
- ❌ Kill Aura - No automated attacking
- ❌ Velocity - No knockback modification  
- ❌ Criticals - No forced critical hits
- ❌ Flight - No creative flying
- ❌ X-Ray - Too obvious and unfair
- ❌ Aggressive PvP features

## 🏗️ Architecture

Thales is built with a modular architecture:

```
┌─────────────────────────────────────┐
│        Thales Client Core           │
├─────────────────────────────────────┤
│  Module System  │  Event System     │
│  Command System │  Config System    │
│  GUI System     │  Render System    │
└─────────────────────────────────────┘
          ↓ Built on ↓
┌─────────────────────────────────────┐
│         Fabric Loader               │
│  Fabric API  │  Mixin Framework     │
└─────────────────────────────────────┘
          ↓ Runs on ↓
┌─────────────────────────────────────┐
│         Minecraft 1.20.x            │
└─────────────────────────────────────┘
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Minecraft Java Edition 1.20.x
- Fabric Loader installed

### Installation

1. Download the latest release from the [Releases](../../releases) page
2. Place the `.jar` file in your `.minecraft/mods` folder
3. Launch Minecraft with Fabric loader
4. Press `Right Shift` to open the ClickGUI (default keybind)

### Building from Source

```bash
# Clone the repository
git clone https://github.com/Ghostwillower/ArMo-client.git
cd ArMo-client

# Build with Gradle
./gradlew build

# The compiled mod will be in build/libs/
```

## 📖 Documentation

- [Assist Client Design](ASSIST_CLIENT_DESIGN.md) - Philosophy and design principles
- [Research Document](RESEARCH.md) - Technical research and design decisions
- [Architecture Guide](ARCHITECTURE.md) - Technical architecture details
- [Contributing Guide](CONTRIBUTING.md) - How to contribute

## 🛠️ Development

### Technology Stack

- **Language**: Java 17
- **Build Tool**: Gradle 8.x
- **Framework**: Fabric Loader + Fabric API (Phase 2)
- **Automation**: Baritone integration (Phase 2)
- **Mixin**: For runtime code modification
- **Minecraft Version**: 1.20.x

### Project Structure

```
thales-client/
├── src/main/java/          # Java source code
│   └── com/thales/         # Main package
│       ├── module/         # Module system
│       ├── event/          # Event system
│       ├── command/        # Command system
│       ├── gui/            # GUI system
│       └── util/           # Utilities
├── src/main/resources/     # Resources
│   ├── fabric.mod.json     # Mod metadata
│   └── thales.mixins.json  # Mixin configuration
└── build.gradle            # Build configuration
```

### Development Roadmap

#### Phase 1: Foundation ✅ Complete
- [x] Research and planning
- [x] Define "under the radar" assist client philosophy  
- [x] Project structure setup
- [x] Event system framework
- [x] Module system framework
- [x] 22 assist-focused modules created
- [x] Baritone integration planning

#### Phase 2: Minecraft Integration ✅ Complete (Documentation & Examples)
- [x] Create Fabric Loom build configuration (`docs/fabric-build.gradle`)
- [x] Implement Fabric mod entry point (`docs/integration/ThalesFabricMod.java`)
- [x] Create Mixin hooks for game tick and player (`docs/integration/mixins/`)
- [x] Add Minecraft utility class (`docs/integration/MinecraftUtil.java`)
- [x] Create Fabric resource files (`docs/integration/*.json`)
- [x] Implement Sprint module with Minecraft API
- [x] Implement Fullbright module with Minecraft API
- [x] Document complete integration approach (`docs/DEVELOPMENT.md`)
- [x] Provide development guide for local Fabric setup
- [ ] Test in actual Minecraft environment (requires local setup)
- [ ] Implement remaining 20 modules
- [ ] Add Baritone API calls
- [ ] Add ClickGUI and HUD

**Phase 2 Status**: Infrastructure complete and fully documented in `docs/` directory. Ready for local Fabric development. See `docs/README.md` for integration instructions.

#### Phase 3: Polish & GUI
- [ ] ClickGUI for module management
- [ ] HUD elements for information display
- [ ] Configuration saving/loading
- [ ] Keybind system

#### Phase 4: Advanced Features
- [ ] Per-server configurations
- [ ] Module presets
- [ ] Advanced Baritone features
- [ ] Optimization and refinement

## 🤝 Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

### Guidelines

- Follow existing code style
- Test your changes thoroughly
- Update documentation as needed
- Ensure code passes all checks

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Fabric Team for the excellent modding framework
- Baritone developers for intelligent pathfinding
- Minecraft modding community for documentation and resources
- Open-source client projects for inspiration

## 📞 Contact

- GitHub Issues: [Report a bug or request a feature](../../issues)
- Discussions: [Join the conversation](../../discussions)

## ⚖️ Legal Notice

Thales is an independent project and is not affiliated with, endorsed by, or connected to Mojang Studios or Microsoft. Minecraft is a trademark of Mojang Studios.

This software is provided "as is" without warranty of any kind. Use at your own risk and responsibility.

---

**Made with ❤️ by the Thales development team**