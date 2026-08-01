# SOLID Principles

Monster Maze 2.0 is designed around the SOLID principles to create a maintainable and extensible architecture.

---

## Single Responsibility Principle

Each class and package has a single responsibility, such as:
- Renderer draws graphics.
- InputManager processes user input.
- AudioManager manages audio.
- CombatSystem resolves combat.
- Inventory manages collected items.
- MazeLoader loads level data.

---

## Open/Closed Principle

The project is designed to allow new features without modifying existing code.

Examples:

- New monster types extend Monster.
- New potion types extend Potion.
- New levels are loaded from external data files.

---

## Liskov Substitution Principle

Derived classes can replace their parent classes without changing program behavior.

Examples:

- Zombie, Ghost, and Skeleton can all be treated as Monster objects.
- Different potion types can be used wherever a Potion is expected.

---

## Interface Segregation Principle

Interfaces will contain only the operations required by the implementing classes.

Examples:

- Drawable
- Movable
- Attackable
- Collectable

Objects implement only the interfaces they require.

---

## Dependency Inversion Principle

High-level systems depend on abstractions rather than concrete implementations.

Examples:

- Gameplay interacts with Monster instead of Zombie.
- Future factories or managers can create entities without exposing implementation details.

---

## Summary

Applying the SOLID principles makes the project easier to extend, maintain, test, and understand while reducing coupling between components.
