## Problem Description

You are designing a **Computer Assembly System** for a custom PC building company. The system needs to handle the creation of different computer configurations with various hardware components.

## Requirements

### Computer Components

A computer can include the following components:

- **Motherboard**: required for all builds
- **CPU**: required for all builds, different models with different performance available
- **RAM**: required for all builds, but quantity varies
- **Storage**: at least one required, can have different technologies
- **Graphics Card**: optional, different models with different performance available
- **Power Supply**: required, with different power levels
- **Case**: required for all builds
- **Cooling System**: optional but recommended

and support different configurations:

1. **Office Computer**: Motherboard + Basic CPU + 8GB RAM + SSD + Integrated Graphics + PSU + Case
2. **Gaming Computer**: Motherboard + Gaming CPU + 16GB+ RAM + SSD + High-end Graphics + PSU + Case + Advanced Cooling
3. **Workstation**: Motherboard + Professional CPU + 32GB+ RAM + Multiple Storage + Professional Graphics + High-wattage PSU + Case + Advanced Cooling
4. **Budget Build**: Motherboard + Entry-level CPU + 4GB RAM + HDD + Basic PSU + Case

Design a solution where components and configurations can be assembled without the clients knowing the details of the computer being built.