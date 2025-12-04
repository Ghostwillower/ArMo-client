# Thales Client - Under the Radar Assist Client Design

## Philosophy

Thales is designed as an **"under the radar" assist client** rather than a full-on aggressive hacking client. The focus is on:

- **Quality of Life**: Features that reduce tedium and improve gameplay experience
- **Subtle Assistance**: Visual aids and automation that don't scream "cheating"
- **Defensive > Offensive**: Protective features prioritized over aggressive combat
- **Baritone Integration**: Intelligent pathfinding and automation using Baritone

## Design Principles

### 1. Subtlety
- No obvious kill aura or auto-attack features
- Visual aids are configurable and subtle
- Features mimic skilled player behavior

### 2. Quality of Life Focus
- Automate repetitive tasks (eating, tool selection, inventory management)
- Provide helpful visual information (ESP for items/chests)
- Improve movement (auto-sprint, step assist, edge detection)

### 3. Safety First
- Anti-void protection
- Safe block breaking (prevents falls)
- Auto-totem management
- Defensive combat assists only

### 4. Baritone Integration
- Leverage Baritone's powerful pathfinding
- Automated mining and walking
- Intelligent goal-based movement

## Module Categories

### Movement Modules (Quality of Life)

**Sprint** - Automatically sprints when moving
- Removes need to hold sprint key
- Checks hunger levels appropriately

**AutoWalk** - Auto-walk with Baritone pathfinding
- Uses Baritone for intelligent navigation
- Can pathfind to coordinates or structures
- Avoids obstacles automatically

**AutoSneak** - Context-aware sneaking
- Automatically sneaks at block edges
- Prevents accidental falls while building
- Releases sneak when safe

**Step** - Enhanced step height
- Step up full blocks without jumping
- Makes navigation smoother
- Quality of life for traversal

**NoSlow** - Removes item use slowdown
- Normal movement while eating/drinking
- Maintains mobility during consumable use
- Not obviously cheating

**AntiVoid** - Void fall protection
- Detects void and prevents falls
- Safety feature for dimension travel
- Prevents deaths from falling into void

**Scaffold** - Safe bridging assistance
- Places blocks beneath player when bridging
- Tower mode for building upward
- Helps with safe building in survival

### Render Modules (Subtle Visual Aids)

**Fullbright** - Maximum brightness
- See in dark areas without torches
- Toggle-able for normal gameplay
- Client-side visual only

**ItemESP** - Highlight items on ground
- Find dropped items easily
- Color-coded by item type
- Helpful for finding loot after deaths

**ChestESP** - Highlight storage containers
- Locate chests, barrels, shulker boxes
- Color-coded by container type
- Useful for base organization

**HoleESP** - Highlight safe holes
- Shows 1x1 holes for safety
- Color-coded by material (bedrock/obsidian)
- Useful for PvP or safety

**Tracers** - Draw lines to entities
- Configurable entity filters
- Color-coded by entity type
- Subtle awareness tool

### Player Modules (Resource Management)

**AutoEat** - Automatic eating
- Eats when hunger is low
- Selects appropriate food from inventory
- Maintains health and hunger automatically

**AutoTool** - Best tool selection
- Automatically switches to best tool for block
- Improves mining efficiency
- Mimics what player would do manually

**InvManager** - Smart inventory management
- Sorts inventory logically
- Drops unwanted items (configurable)
- Keeps important items in hotbar

**ChestStealer** - Quick chest looting
- Rapidly transfers items from chests
- Skips blacklisted items
- Saves time on repetitive clicking

### World Modules (Building & Mining Assists)

**SafeBreak** - Safe block breaking
- Prevents breaking blocks that cause falls
- Warns player of dangerous mining
- Safety feature for cave exploration

**AutoMine** - Automated mining with Baritone
- Uses Baritone to locate and mine ores
- Configurable ore types
- Automates repetitive mining tasks

**NoWeather** - Remove weather effects
- Client-side weather removal
- Improves visibility and FPS
- Visual preference only

### Combat Modules (Defensive Only)

**AutoTotem** - Automatic totem management
- Keeps totem in offhand
- Replaces used totems
- Safety feature, not combat advantage

**AutoShield** - Automatic shield raising
- Raises shield when projectiles detected
- Defensive assist only
- Improves reaction time for blocking

## What We DON'T Include

To maintain the "under the radar" philosophy, we explicitly **do not** include:

- ❌ Kill Aura - Automated attacking
- ❌ Velocity - Knockback modification for PvP advantage
- ❌ Criticals - Forced critical hits
- ❌ Reach - Extended attack/interact range
- ❌ FastBreak - Instant block breaking
- ❌ Flight - Creative mode flying in survival
- ❌ Speed - Unrealistic movement speed
- ❌ X-Ray - See-through walls for ores (too obvious)
- ❌ No Fall - Complete fall damage removal

These features are too aggressive and obvious, making them incompatible with the "assist client" philosophy.

## Baritone Integration

Baritone is integrated for intelligent automation:

### Pathfinding
- Navigate to coordinates
- Find structures
- Avoid obstacles
- Handle complex terrain

### Mining
- Locate specific ore types
- Mine efficiently
- Return to base when inventory full
- Pathfind around hazards

### Building
- Execute build plans
- Place blocks intelligently
- Handle complex structures

## Use Cases

### Legitimate Use
- ✅ Single-player quality of life
- ✅ Private servers with permission
- ✅ Testing and development
- ✅ Educational purposes
- ✅ Content creation (with disclosure)

### Prohibited Use
- ❌ Public servers without permission
- ❌ Competitive PvP servers
- ❌ Any server where modifications are banned
- ❌ Griefing or malicious purposes

## Configuration

All modules are:
- Individually toggleable
- Configurable via settings
- Can be bound to keybinds
- Saved per-server (future feature)

## Detection Resistance

While we don't explicitly support rule-breaking:

1. **Behavior Mimicry**: Features mimic skilled player behavior
2. **Subtle Visual Aids**: ESP and tracers are configurable to be subtle
3. **No Packet Manipulation**: Avoid obvious server-side red flags
4. **Natural Timing**: Actions have human-like delays
5. **Configurable**: All features can be toned down or disabled

## Future Enhancements

### Phase 2: Minecraft Integration
- Connect modules to actual game state
- Implement Baritone API integration
- Add mixin hooks for module functionality

### Phase 3: Advanced Configuration
- Per-server configurations
- Module presets
- Advanced settings GUI

### Phase 4: Refinement
- Machine learning for natural behavior
- Advanced anti-detection
- Performance optimization

## Conclusion

Thales is designed to be a **helpful assistant** rather than a **blatant cheat client**. Every feature is chosen to enhance gameplay without being obviously unfair. The focus on quality of life, safety, and Baritone integration makes it a powerful tool for players who want assistance without the stigma of aggressive hacking.
