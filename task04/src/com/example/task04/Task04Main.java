package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        logger1.debug("debug");
        logger2.info("info");
        logger1.warning("warning");
        logger2.error(
                "template: [%s] %s %s - %s",
                logger2.getLevel(), "now", logger2.getName(), "error");
    }
}
