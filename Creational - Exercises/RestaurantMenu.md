## Problem Description

You are developing a menu management system for an international restaurant chain that serves different cuisines: **Italian** and **Chinese**. Each cuisine has its own cooking style, ingredients, and presentation, but the restaurant operations remain consistent.

Your system needs to handle two types of menu items:

- **Appetizer**
- **MainCourse**

The challenge is that each cuisine requires different preparation methods and ingredients:

### Italian Cuisine Menu

- **Italian Appetizer**
- **Italian Main Course**

### Chinese Cuisine Menu

- **Chinese Appetizer**
- **Chinese Main Course**

## Requirements

1. **Menu Item Interface**: All menu items should have methods to:
   - `prepare()`: Display the preparation process
   - `serve()`: Display how the dish is served
   - `getDescription()`: Return a description of the dish and its key ingredients

2. **Cuisine Consistency**: When a restaurant selects a cuisine theme, all menu items should belong to that cuisine (no mixing Italian appetizers with Chinese main courses).

3. **Expandability**: The system should be easily extensible to add new cuisines (like Mexican, Indian) or new menu categories (like Dessert, Beverage) without modifying existing code.