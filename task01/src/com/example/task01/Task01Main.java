package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {





        Logger logger1 = Logger.getLogger("test");

        logger1.setLevel(Logger.Level.INFO);

        Logger logger = new Logger("test");

        logger.setLevel(Logger.Level.ERROR);

        logger.error("feff");
        logger.info("fef");
    }
}
