package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test", new ConsoleHandler());
        logger.setLevel(Logger.Level.DEBUG);
        logger.debug("debug smth");
        logger.error("Database is not available now");
    }
}
