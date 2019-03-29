package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test");

        logger.addMessageHandler(new ConsoleHandler());
        logger.addMessageHandler(new FileHandler("log.log"));
        logger.addMessageHandler(new RotationFileHandler("log.log", ChronoUnit.SECONDS));
        logger.addMessageHandler(new MemoryHandler(3, new ConsoleHandler()));

        try {
            logger.debug("test message");
            logger.warning("warning message");
            Thread.sleep(1000);
            logger.error("error message");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
