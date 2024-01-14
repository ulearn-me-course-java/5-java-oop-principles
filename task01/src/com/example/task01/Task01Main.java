package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {

        Logger logger = new Logger("MyLogger", Level.DEBUG);
        logger.setLevel(Level.DEBUG);

        Logger logger2 = Logger.getLogger("MyLogger");
        System.out.println("logger == logger2: " + (logger == logger2));

        logger.info("This is an info message");
        logger.debug("This is a debug message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");

        logger.info("Formatted message: {0}", "This is a formatted message");
        logger.error("Error message with {0} and {1}", "arguments", 123);

        Logger anotherLogger = Logger.getLogger("AnotherLogger");

        System.out.println("Logger name: " + logger.getName());

        anotherLogger.setLevel(Level.WARNING);
        anotherLogger.debug("Debug message for AnotherLogger");

        anotherLogger.setLevel(Level.ERROR);
        anotherLogger.error("Error message for AnotherLogger");
    }
}
