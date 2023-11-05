package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");


        logger1.info("test1");
        logger1.error("test1");
        logger1.debug("test1");
        logger1.warning("test1");

        logger1.error("Hello %s", "Axel");
    }
}