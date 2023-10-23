package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger loggerTest1 = Logger.getLogger("test");
        Logger loggerTest2 = Logger.getLogger("test");
        System.out.println(loggerTest1==loggerTest2);

        Logger logger1 = new Logger("test", LoggerLevel.DEBUG);
        Logger logger2 = Logger.getLogger("test");
        logger1.error("u vas oshibka!!!");
        logger1.debug("debug started...");
        logger2.setLevel(LoggerLevel.WARNING);
        logger1.warning("[{0}] [{1}] - {2}", logger2.getLevel(), logger1.getName(), " debug errors...");
        logger1.error("ERROR");


    }
}
