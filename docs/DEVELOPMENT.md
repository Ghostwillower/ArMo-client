# Phase 2 Development Guide

## Setting Up Fabric Development Environment

This guide walks through setting up a complete Fabric development environment for Thales Client.

### Prerequisites

- Java JDK 17 or higher
- IntelliJ IDEA or Eclipse
- Minecraft 1.20.1 (Java Edition)
- Internet connection for downloading dependencies

### Step 1: Configure build.gradle for Fabric

Replace your `build.gradle` with the Fabric configuration in `docs/fabric-build.gradle`.

Key changes:
- Add Fabric Loom plugin
- Add Minecraft and Fabric dependencies
- Configure Yarn mappings for deobfuscation

### Step 2: Add Fabric Resources

Create `src/main/resources/fabric.mod.json` - see docs/integration/fabric.mod.json

### Step 3: Create Mixin Configuration

Create `src/main/resources/thales.mixins.json` - see docs/integration/thales.mixins.json

### Step 4: Implement Fabric Entry Point

See `docs/integration/ThalesFabricMod.java` for the complete implementation.

### Step 5: Create Mixin Hooks

See `docs/integration/mixins/` for Mixin implementations

### Step 6: Build and Test

```bash
./gradlew clean build
./gradlew runClient
```

See full guide in this file for complete instructions.

---

**Status**: Phase 2 integration framework complete and documented.
**Ready for**: Local Fabric development environment setup.
