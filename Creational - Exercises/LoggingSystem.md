## Problem Description

You are developing a software monitoring system that needs to log events to different destinations based on the severity level and system requirements. The system should be able to create different types of loggers without the client code knowing the specific implementation details.

The system should support:

1. **Console Logger**: Logs messages directly to the console/terminal
2. **File Logger**: Logs messages to a file on the filesystem
3. **Database Logger**: Logs messages to a database table

## Requirements

1. **Logging Interface**: Each logger type should implement a common interface for logging messages with different logging levels, like:
   - `debug`
   - `warning`
   - ...

2. **Extensibility**: The implementation should be easily extensible to add new logger types
