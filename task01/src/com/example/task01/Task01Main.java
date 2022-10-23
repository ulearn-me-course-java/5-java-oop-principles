package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        logger1.debug("debug");
        logger2.info("info");
        logger1.warning("warning");
        logger2.error(
                "template: [{0}] {1} {2} - {3}",
                logger2.getLevel(), "now", logger2.getName(), "error");
    }
}
