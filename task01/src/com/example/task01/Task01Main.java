package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = new Logger("test", LoggerLevel.DEBUG);
        Logger logger2 = Logger.getLogger("test");
        logger1.error("error!!!");
        logger1.debug("debug started...");
        logger2.setLevel(LoggerLevel.WARNING);
        logger1.warning("[{0}] [{1}] - {2}", logger2.getLevel(), logger1.getName(), "2) debug...");
        logger1.error("error-error-error");
    }
}
