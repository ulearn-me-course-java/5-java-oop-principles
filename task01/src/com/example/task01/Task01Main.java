package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = new Logger("testLogger");
        logger1.log(Logger.Level.INFO, "some test message");
        logger1.setLevel(Logger.Level.WARNING);
        logger1.debug("this message won't be displayed");
        logger1.info("this message won't be displayed");
        logger1.warning("this message will be displayed");
        logger1.error("this message will be displayed");
    }
}
