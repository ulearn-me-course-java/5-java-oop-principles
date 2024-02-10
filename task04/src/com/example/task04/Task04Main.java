package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test1", Logger.Level.WARNING, new ConsoleHandler());
        logger.setLevel(Logger.Level.DEBUG);
        logger.debug("test2");
        logger.error("test3");
    }
}
