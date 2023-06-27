package com.example.task04;

import java.util.ArrayList;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("Test Logger");
        MessageHandler consoleHandler = new ConsoleHandler();
        MessageHandler fileHandler = new FileHandler("log");

        logger.addMessageHandler(fileHandler);
        logger.setLevel(Level.ERROR);
        logger.log(Level.ERROR, "Test ERROR");
        logger.log(Level.ERROR, "Test ERROR %s", "1234");
        logger.log(Level.INFO, "Test INFO");
        logger.log(Level.WARNING, "Test WARNING");
        logger.log(Level.DEBUG, "Test DEBUG");
    }
}