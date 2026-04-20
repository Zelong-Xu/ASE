## Problem Description

You are developing a role-playing game (RPG) that supports multiple themes: **Medieval** and **Sci-Fi**. Each theme has its own visual style and character types, but the game mechanics remain the same.

In your game, players can choose between two character classes:

- **Warrior**
- **Mage**

The challenge is that each theme requires different implementations of these character classes:

### Medieval Theme Characters

- **Medieval Warrior**
- **Medieval Mage**

### Sci-Fi Theme Characters

- **Sci-Fi Warrior**
- **Sci-Fi Mage**

## Requirements

1. **Character Interface**: All characters should have methods to:
   - `attack()`: Display their attack method
   - `defend()`: Display their defense method
   - `getDescription()`: Return a description of the character

2. **Theme Consistency**: When a player selects a theme, all characters created should belong to that theme (no mixing Medieval warriors with Sci-Fi mages).

3. **Extensibility**: The system should be easily extensible to add new themes (like Fantasy, Cyberpunk) or new character classes (like Archer, Healer) without modifying existing code.
