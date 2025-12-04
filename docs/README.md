# Phase 2 Integration Documentation

This directory contains complete Fabric Minecraft integration code and configuration for Thales Client Phase 2.

## Directory Structure

```
docs/
├── DEVELOPMENT.md - Complete development guide
├── fabric-build.gradle - Fabric Loom build configuration
├── fabric-gradle.properties - Fabric dependency versions
├── fabric-settings.gradle - Plugin repository configuration
└── integration/
    ├── ThalesFabricMod.java - Fabric mod entry point
    ├── MinecraftUtil.java - Minecraft object access utility
    ├── fabric.mod.json - Fabric mod metadata
    ├── thales.mixins.json - Mixin configuration
    ├── mixins/
    │   ├── MinecraftClientMixin.java - Game tick hook
    │   └── ClientPlayerEntityMixin.java - Player hook
    └── modules/
        ├── Sprint.java - Example: Auto-sprint implementation
        └── Fullbright.java - Example: Gamma control implementation
```

## How to Use

### For Local Development

1. **Set up Fabric environment:**
   - Copy `fabric-build.gradle` to root `build.gradle`
   - Merge `fabric-gradle.properties` into root `gradle.properties`
   - Copy `fabric-settings.gradle` to root `settings.gradle`

2. **Add integration code:**
   - Copy `integration/ThalesFabricMod.java` to `src/main/java/com/thales/integration/`
   - Copy `integration/MinecraftUtil.java` to `src/main/java/com/thales/util/`
   - Copy mixin files to `src/main/java/com/thales/mixin/`
   - Copy resource files to `src/main/resources/`

3. **Build and run:**
   ```bash
   ./gradlew clean build
   ./gradlew runClient
   ```

### For Understanding Implementation

- Read `DEVELOPMENT.md` for complete guide
- Review `integration/` files to see Fabric integration
- Check `modules/` for example module implementations

## Key Integration Points

### 1. Fabric Entry Point
`ThalesFabricMod.java` implements `ClientModInitializer` and is called by Fabric Loader when Minecraft starts.

### 2. Mixin Hooks
- `MinecraftClientMixin` - Injects into game tick for module updates
- `ClientPlayerEntityMixin` - Hooks player for module functionality

### 3. Module Pattern
All modules follow this pattern:
```java
if (!MinecraftUtil.isInWorld()) return;
ClientPlayerEntity player = MinecraftUtil.getPlayer();
// ... module logic ...
```

### 4. Resource Files
- `fabric.mod.json` - Tells Fabric Loader about the mod
- `thales.mixins.json` - Tells Mixin which hooks to apply

## Module Implementation Status

**Fully Implemented (2/22):**
- ✅ Sprint - Auto-sprint with Minecraft API
- ✅ Fullbright - Gamma control with Minecraft API

**Ready for Implementation (20/22):**
All other modules have placeholders and are ready for Minecraft API integration following the Sprint/Fullbright pattern.

## Next Steps

1. Set up local Fabric development environment
2. Copy integration files as described above
3. Build and test in Minecraft
4. Implement remaining 20 modules
5. Add Baritone API integration
6. Add ClickGUI and HUD

## Requirements

- Java 17+
- Minecraft 1.20.1
- Fabric Loader 0.15.3+
- Fabric API 0.92.0+

## Notes

- These files are **examples and documentation**
- They show the complete Fabric integration approach
- The current repository builds without Fabric for CI/CD
- For local development, apply the Fabric configuration

---

**Status**: Phase 2 infrastructure complete and documented  
**Ready for**: Local Fabric development and testing
