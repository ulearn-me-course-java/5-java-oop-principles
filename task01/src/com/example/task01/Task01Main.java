package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getLogger("test1");
        Logger logger2 = Logger.getLogger("test1");
        System.out.println(logger1 == logger2);

        logger1.debug("some message 1");
        logger1.info("some message 1");
        logger1.warning("some message 1");
        logger1.error("some message 1");

        System.out.println(logger1.getLevel());
        logger1.setLevel(Logger.Level.WARNING);

        logger1.debug("some message 2");
        logger1.info("some message 2");
        logger1.warning("some message 2");
        logger1.error("some message 2");

        logger1.log(Logger.Level.ERROR, "log error");
        logger2.log(Logger.Level.ERROR, "0x%x: %s", 0x1223, "log debug");
    }
}