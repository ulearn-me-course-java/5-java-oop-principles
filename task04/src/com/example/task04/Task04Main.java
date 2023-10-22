package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        MemoryHandler memoryHandler = new MemoryHandler(3, new ConsoleHandler());
        Logger logger = new Logger("test", memoryHandler);
        logger.info("test1");
        logger.info("test2");
        logger.info("test3");
        logger.info("test4");
        logger.info("test5");
        memoryHandler.logMessages();
        memoryHandler.log("6");
        memoryHandler.log("7");

        logger.setHandler(new FileHandler());
        logger.info("test");

        logger.setHandler(new RotationFileHandler(ChronoUnit.MINUTES));
        logger.info("test");
        logger.setHandler(new RotationFileHandler(ChronoUnit.HOURS));
        logger.info("test");
    }
}
