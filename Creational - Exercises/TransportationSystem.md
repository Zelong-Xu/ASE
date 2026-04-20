## Problem Description

You are developing a transportation management system for a global logistics company that operates in different regions: **Europe** and **Asia**. Each region has different vehicle manufacturers and specifications, but the core transportation functionality remains the same.

Your system needs to handle two types of vehicles:

- **Car**
- **Truck**

The challenge is that each region works with different manufacturers and vehicle specifications:

### European Region Vehicles

- **European Car**
- **European Truck**

### Asian Region Vehicles

- **Asian Car**
- **Asian Truck**

## Requirements

1. **Vehicle Interface**: All vehicles should have methods to:
   - `start()`: Display how the vehicle starts
   - `transport()`: Display the vehicle's transportation method
   - `getSpecifications()`: Return the vehicle's key specifications

2. **Regional Consistency**: When a regional office selects vehicles, all vehicles should come from manufacturers in that region (no mixing European cars with Asian trucks).

3. **Scalability**: The system should be easily extensible to add new regions (like North America, South America) or new vehicle types (like Motorcycle, Van) without modifying existing code.