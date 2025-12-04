# Thales Client

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Minecraft](https://img.shields.io/badge/minecraft-1.20.x-green.svg)
![Status](https://img.shields.io/badge/status-in%20development-yellow.svg)

**Thales** is a Minecraft utility client built on Fabric, designed to provide advanced gameplay enhancements, resource management, and quality of life improvements. Named after Thales of Miletus, the first Greek philosopher, this client embodies foundational wisdom and innovative thinking.

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

**Thales** is a comprehensive Minecraft client named after Thales of Miletus (c. 624 – c. 545 BC), recognized as the first philosopher in Greek tradition and the father of science. Just as Thales sought to understand the fundamental principles of nature, Thales Client provides:

- 🛠️ **Resource Management**: Advanced inventory and resource handling
- ⚡ **Performance Enhancements**: Optimized gameplay experience
- 🎮 **Quality of Life**: Automation and convenience features
- 🎨 **Visual Enhancements**: ESP, tracers, and rendering improvements
- ⌨️ **Command System**: Powerful in-game commands

## ✨ Features (Planned)

### Module Categories

#### 🗡️ Combat
- Killaura - Automatic entity targeting
- Velocity - Knockback modification
- Criticals - Force critical hits
- AutoTotem - Automatic totem management

#### 🏃 Movement
- Sprint - Auto-sprint functionality
- Fly - Flight capabilities
- Speed - Enhanced movement speed
- NoFall - Fall damage prevention

#### 👁️ Render
- Fullbright - Maximum visibility
- ESP - Entity highlighting
- Tracers - Entity tracking lines
- Nametags - Enhanced name displays

#### 👤 Player
- FastBreak - Faster block breaking
- FastPlace - Faster block placement
- AutoEat - Automatic hunger management
- InvManager - Smart inventory sorting

#### 🌍 World
- Xray - See through blocks
- ChestESP - Highlight containers
- NoWeather - Weather control

#### 🔧 Misc
- MiddleClick - Customizable middle-click actions
- AutoReconnect - Auto-reconnect on disconnect
- FakePlayer - Testing utilities

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

- [Research Document](RESEARCH.md) - Technical research and design decisions
- [Contributing Guide](CONTRIBUTING.md) - How to contribute (coming soon)
- [Module Documentation](docs/MODULES.md) - Detailed module information (coming soon)

## 🛠️ Development

### Technology Stack

- **Language**: Java 17
- **Build Tool**: Gradle 8.x
- **Framework**: Fabric Loader + Fabric API
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

#### Phase 1: Foundation ✅ (Current)
- [x] Research and planning
- [x] Define Thales branding and purpose
- [ ] Project structure setup
- [ ] Basic Fabric mod skeleton
- [ ] Event system framework

#### Phase 2: Core Systems
- [ ] Module system implementation
- [ ] Command system
- [ ] Configuration management
- [ ] Basic GUI framework

#### Phase 3: Essential Modules
- [ ] Movement modules
- [ ] Render modules
- [ ] Player utility modules

#### Phase 4: Advanced Features
- [ ] Advanced GUI (ClickGUI)
- [ ] HUD system
- [ ] Additional modules
- [ ] Optimization

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
- Minecraft modding community for documentation and resources
- Open-source client projects for inspiration (Meteor, Wurst)

## 📞 Contact

- GitHub Issues: [Report a bug or request a feature](../../issues)
- Discussions: [Join the conversation](../../discussions)

## ⚖️ Legal Notice

Thales is an independent project and is not affiliated with, endorsed by, or connected to Mojang Studios or Microsoft. Minecraft is a trademark of Mojang Studios.

This software is provided "as is" without warranty of any kind. Use at your own risk and responsibility.

---

**Made with ❤️ by the Thales development team**