public class LoggingSystemDemo {
    // Common interface for all loggers
    public interface Logger {
        void debug(String message);
        void warning(String message);
        // Additional levels like error, info can be added, but keeping minimal
    }

    // Abstract creator class for Factory Method pattern
    public static abstract class LoggerFactory {
        // The factory method that subclasses will implement
        public abstract Logger createLogger();
        
        // Optional: a method to demonstrate usage, but not necessary for the pattern
        public void logMessage(String level, String message) {
            Logger logger = createLogger();
            if ("debug".equals(level)) {
                logger.debug(message);
            } else if ("warning".equals(level)) {
                logger.warning(message);
            }
        }
    }

    // Concrete Logger for console
    public static class ConsoleLogger implements Logger {
        // Adding Singleton pattern as optional enhancement
        private static ConsoleLogger instance;
        
        private ConsoleLogger() {}  // Private constructor for Singleton
        
        public static synchronized ConsoleLogger getInstance() {
            if (instance == null) {
                instance = new ConsoleLogger();
            }
            return instance;
        }
        
        @Override
        public void debug(String message) {
            System.out.println("Console Debug: " + message);
        }
        
        @Override
        public void warning(String message) {
            System.out.println("Console Warning: " + message);
        }
    }

    // Concrete Logger for file (minimal implementation, no real file I/O)
    public static class FileLogger implements Logger {
        // Adding Singleton pattern as optional enhancement
        private static FileLogger instance;
        
        private FileLogger() {}  // Private constructor for Singleton
        
        public static synchronized FileLogger getInstance() {
            if (instance == null) {
                instance = new FileLogger();
            }
            return instance;
        }
        
        @Override
        public void debug(String message) {
            System.out.println("File Debug: " + message);  // Simulating file log
        }
        
        @Override
        public void warning(String message) {
            System.out.println("File Warning: " + message);  // Simulating file log
        }
    }

    // Concrete Logger for database (minimal implementation, no real DB connection)
    public static class DatabaseLogger implements Logger {
        // Adding Singleton pattern as optional enhancement
        private static DatabaseLogger instance;
        
        private DatabaseLogger() {}  // Private constructor for Singleton
        
        public static synchronized DatabaseLogger getInstance() {
            if (instance == null) {
                instance = new DatabaseLogger();
            }
            return instance;
        }
        
        @Override
        public void debug(String message) {
            System.out.println("Database Debug: " + message);  // Simulating DB log
        }
        
        @Override
        public void warning(String message) {
            System.out.println("Database Warning: " + message);  // Simulating DB log
        }
    }

    // Concrete factory for ConsoleLogger
    public static class ConsoleLoggerFactory extends LoggerFactory {
        @Override
        public Logger createLogger() {
            // Using Singleton instance
            return ConsoleLogger.getInstance();
        }
    }

    // Concrete factory for FileLogger
    public static class FileLoggerFactory extends LoggerFactory {
        @Override
        public Logger createLogger() {
            // Using Singleton instance
            return FileLogger.getInstance();
        }
    }

    // Concrete factory for DatabaseLogger
    public static class DatabaseLoggerFactory extends LoggerFactory {
        @Override
        public Logger createLogger() {
            // Using Singleton instance
            return DatabaseLogger.getInstance();
        }
    }

    // Example client code to demonstrate usage (not part of the pattern, just for illustration)
    public static void main(String[] args) {
        // Client chooses the factory based on requirement, but doesn't know the concrete logger impl details
        LoggerFactory factory = new ConsoleLoggerFactory();
        Logger logger = factory.createLogger();
        logger.debug("This is a debug message");
        logger.warning("This is a warning message");
        
        // Easily switch to another type
        factory = new FileLoggerFactory();
        logger = factory.createLogger();
        logger.debug("This is a debug message in file");
        
        // Extensibility: To add a new logger, create new Logger impl and new Factory subclass
    }
}