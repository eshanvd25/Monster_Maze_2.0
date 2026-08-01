# Monster Maze 2.0 - Architecture

# High-Level Architecture

![High Level Architecture](src/docs/diagrams/High_Level_Architecture.png)

## Purpose

The Game Engine controls the application's execution and coordinates the major systems.

The State Manager controls which screen is currently active, such as the Main Menu, Gameplay, Settings, or Pause menu.

The Resource Manager loads and manages game assets including sprites, fonts, and configuration files.

The Input Manager processes keyboard input and translates user actions into game commands.

The Audio Manager controls background music and sound effects.

---

# Gameplay Architecture

![Gameplay](src/docs/diagrams/GamePlay.png)

## Purpose

The Gameplay State represents the active game.

Gameplay is divided into several independent systems:

- Maze generation and loading
- Entity management
- Hero
- Monsters
- Items
- Gameplay systems such as combat and inventory

This separation allows new gameplay features to be added without modifying unrelated systems.

---

# Game Loop

![Game Loop](src/docs/diagrams/GameLoop.png)

## Purpose

The Game Engine continuously executes the following cycle:

1. Handle player input
2. Update the game state
3. Render the current frame

This loop continues until the game is closed.

---

# Package Structure

![Package Structure](src/docs/diagrams/Package_Structure.png)

## Purpose

The project is divided into four primary modules.

### Core

Contains the game engine and application logic.

- Engine
- States
- Input

### Gameplay

Contains gameplay mechanics.

- Maze
- Entities
- Monsters
- Items
- Combat
- Inventory

### Presentation

Responsible for everything visible or audible.

- Graphics
- Audio
- User Interface

### Resources

Contains external assets and game data.

---

# Class Relationships

![Relationships](src/docs/diagrams/Relationships.png)

## Purpose

The relationship diagram illustrates how the major classes communicate while maintaining low coupling.

The Game Engine manages the application's execution.

The State Manager controls the active game state.

Gameplay interacts with the maze, entities, combat system, and inventory while keeping responsibilities separated.

---

# Design Goals

The architecture was designed with the following objectives:

- Follow SOLID principles
- Keep systems modular
- Reduce coupling between components
- Increase maintainability
- Simplify testing
- Allow future expansion without major redesign
