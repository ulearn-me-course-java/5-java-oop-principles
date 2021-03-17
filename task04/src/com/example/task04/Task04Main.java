package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("name");
        logger.addHandler(new ConsoleHandler());
        logger.addHandler(new FileHandler());

        logger.info("something info");
    }
}
