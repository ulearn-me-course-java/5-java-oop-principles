package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = new Logger("test");

        logger.addMessageHandler(new ConsoleHandler());
        logger.addMessageHandler(new FileHandler("testFile"));
        logger.addMessageHandler(new RotationFileHandler("testFile", ChronoUnit.SECONDS));
        logger.addMessageHandler(new MemoryHandler(3));

        logger.debug("test message");
        logger.warning("warning message");
        Thread.sleep(1000);
        logger.error("error message");
    }
}
