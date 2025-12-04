# Contributing to ArMo Client

Thank you for your interest in contributing to ArMo Client! This guide will help you get started.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Setup](#development-setup)
- [Project Structure](#project-structure)
- [How to Contribute](#how-to-contribute)
- [Coding Guidelines](#coding-guidelines)
- [Testing](#testing)
- [Submitting Changes](#submitting-changes)

## Code of Conduct

By participating in this project, you agree to:
- Be respectful and inclusive
- Use the client responsibly and ethically
- Follow server rules and terms of service
- Not use the client for griefing or unauthorized purposes

## Getting Started

### Prerequisites

- Java 17 or higher
- Gradle 8.5 or higher (wrapper included)
- Git
- A Java IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Fork and Clone

1. Fork the repository on GitHub
2. Clone your fork:
```bash
git clone https://github.com/YOUR_USERNAME/ArMo-client.git
cd ArMo-client
```

3. Add upstream remote:
```bash
git remote add upstream https://github.com/Ghostwillower/ArMo-client.git
```

## Development Setup

### Building the Project

```bash
# Build the project
./gradlew build

# Run the client demo
./gradlew runClient

# View project info
./gradlew projectInfo
```

### IDE Setup

#### IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → Select the ArMo-client directory
3. Wait for Gradle to sync
4. Run configurations will be created automatically

#### Eclipse
1. Import → Gradle → Existing Gradle Project
2. Select the ArMo-client directory
3. Finish

#### VS Code
1. Open the ArMo-client directory
2. Install Java Extension Pack
3. Gradle for Java extension should detect the project

## Project Structure

```
ArMo-client/
├── src/main/java/com/armo/
│   ├── ArMoClient.java          # Main entry point
│   ├── module/                   # Module system
│   │   ├── Module.java          # Base module class
│   │   ├── ModuleManager.java   # Module management
│   │   ├── Category.java        # Module categories
│   │   └── modules/             # Individual modules
│   │       ├── combat/
│   │       ├── movement/
│   │       ├── render/
│   │       ├── player/
│   │       ├── world/
│   │       └── misc/
│   ├── event/                    # Event system
│   │   ├── Event.java           # Base event
│   │   ├── EventManager.java    # Event bus
│   │   ├── EventHandler.java    # Annotation
│   │   └── events/              # Event types
│   ├── command/                  # Command system
│   │   ├── Command.java         # Base command
│   │   ├── CommandManager.java  # Command handling
│   │   └── commands/            # Individual commands
│   ├── setting/                  # Settings
│   │   └── Setting.java         # Base setting
│   └── [future packages]
├── RESEARCH.md                   # Research document
├── ARCHITECTURE.md               # Architecture guide
├── README.md                     # Main README
└── build.gradle                  # Build configuration
```

## How to Contribute

### Types of Contributions

1. **Bug Reports**: Found a bug? Open an issue with details
2. **Feature Requests**: Have an idea? Open an issue to discuss
3. **Code Contributions**: Fix bugs or implement features
4. **Documentation**: Improve docs, add examples
5. **Testing**: Test features and report issues

### Creating a New Module

1. Create a new class in the appropriate category package
2. Extend the `Module` class
3. Implement required methods
4. Register in `ModuleManager`

Example:
```java
package com.armo.module.modules.movement;

import com.armo.module.Category;
import com.armo.module.Module;

public class YourModule extends Module {
    public YourModule() {
        super("ModuleName", "Description here", Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        // Called when enabled
    }
    
    @Override
    public void onDisable() {
        // Called when disabled
    }
    
    @Override
    public void onUpdate() {
        // Called every tick when enabled
    }
}
```

Then register in `ModuleManager.registerModules()`:
```java
addModule(new YourModule());
```

### Creating a New Command

1. Create a class in `com.armo.command.commands`
2. Extend the `Command` class
3. Implement `execute()` and `getUsage()`
4. Register in `CommandManager`

Example:
```java
package com.armo.command.commands;

import com.armo.command.Command;

public class YourCommand extends Command {
    public YourCommand() {
        super("commandname", "Description", "alias1", "alias2");
    }
    
    @Override
    public void execute(String[] args) {
        // Command logic here
    }
    
    @Override
    public String getUsage() {
        return ".commandname <args>";
    }
}
```

Then register in `CommandManager.registerCommands()`:
```java
addCommand(new YourCommand());
```

### Creating a New Event

1. Create a class in `com.armo.event.events`
2. Extend the `Event` class
3. Add any event-specific fields

Example:
```java
package com.armo.event.events;

import com.armo.event.Event;

public class YourEvent extends Event {
    private final Object data;
    
    public YourEvent(Object data) {
        super();
        this.data = data;
    }
    
    public Object getData() {
        return data;
    }
}
```

## Coding Guidelines

### Code Style

- Follow standard Java naming conventions
- Use meaningful variable and method names
- Keep methods focused and concise
- Add comments for complex logic
- Use 4 spaces for indentation (no tabs)

### Naming Conventions

- Classes: PascalCase (`ModuleManager`, `TickEvent`)
- Methods: camelCase (`onEnable`, `getModule`)
- Variables: camelCase (`moduleManager`, `isEnabled`)
- Constants: UPPER_SNAKE_CASE (`MOD_NAME`, `VERSION`)
- Packages: lowercase (`com.armo.module`)

### Documentation

- Add Javadoc comments for public classes and methods
- Document non-obvious logic
- Update README.md when adding major features
- Keep documentation in sync with code

Example:
```java
/**
 * Manages all client modules
 */
public class ModuleManager {
    /**
     * Get a module by name
     * @param name The name of the module
     * @return The module, or null if not found
     */
    public Module getModule(String name) {
        // Implementation
    }
}
```

### Best Practices

1. **Single Responsibility**: Each class should have one purpose
2. **DRY**: Don't Repeat Yourself - extract common logic
3. **KISS**: Keep It Simple, Stupid - avoid over-engineering
4. **Error Handling**: Handle errors gracefully
5. **Performance**: Consider performance impact
6. **Security**: Never commit secrets or sensitive data

### Anti-Patterns to Avoid

- ❌ Hardcoding values that should be configurable
- ❌ God classes that do everything
- ❌ Deep nesting (prefer early returns)
- ❌ Magic numbers without explanation
- ❌ Swallowing exceptions silently
- ❌ Copying code instead of refactoring

## Testing

### Manual Testing

1. Build the project: `./gradlew build`
2. Run the client: `./gradlew runClient`
3. Test your changes thoroughly
4. Verify no regressions

### What to Test

- Module enable/disable works correctly
- Commands execute properly
- Events fire as expected
- No exceptions or errors in logs
- Changes don't break existing functionality

### Test Checklist

- [ ] Code compiles without errors
- [ ] No warnings introduced
- [ ] Feature works as intended
- [ ] Edge cases handled
- [ ] Documentation updated
- [ ] No performance regressions

## Submitting Changes

### Before Submitting

1. Update from upstream:
```bash
git fetch upstream
git rebase upstream/main
```

2. Test your changes:
```bash
./gradlew clean build
./gradlew runClient
```

3. Commit your changes:
```bash
git add .
git commit -m "Brief description of changes"
```

### Commit Message Guidelines

Good commit messages help maintain project history:

```
Add Sprint module for auto-sprinting

- Implemented Sprint module in movement category
- Added keybind support
- Updated ModuleManager registration
- Added tests for Sprint functionality
```

Format:
- First line: Brief summary (50 chars or less)
- Blank line
- Detailed description in bullet points
- Reference issues: `Fixes #123` or `Closes #456`

### Creating a Pull Request

1. Push to your fork:
```bash
git push origin your-branch-name
```

2. Go to GitHub and create a Pull Request
3. Fill out the PR template
4. Wait for review

### PR Checklist

- [ ] Descriptive title
- [ ] Detailed description of changes
- [ ] Reference related issues
- [ ] Tests pass
- [ ] Documentation updated
- [ ] No merge conflicts
- [ ] Follows coding guidelines

## Review Process

1. **Automated Checks**: CI will run builds and tests
2. **Code Review**: Maintainers will review your code
3. **Feedback**: Address any requested changes
4. **Merge**: Once approved, your PR will be merged

## Getting Help

- **Issues**: Open an issue for bugs or questions
- **Discussions**: Use GitHub Discussions for general questions
- **Documentation**: Check ARCHITECTURE.md and RESEARCH.md

## License

By contributing, you agree that your contributions will be licensed under the MIT License.

## Recognition

Contributors will be recognized in:
- GitHub contributors page
- Release notes (for significant contributions)
- README.md (for major features)

---

Thank you for contributing to ArMo Client! 🎉
