package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test");
        logger.setHandlers(new MessageHandler[] { new MemoryHandler(2, new RotationFileHandler("path", ChronoUnit.HOURS),
                new ConsoleHandler()), new FileHandler("path") });
        logger.setLevel(LogSeverityLvl.WARNING);
        logger.error("test message");
        logger.warning("test message 2");
        logger.debug("test message 3");
        logger.warning("test message 4");
        logger.warning("test message 5");
    }
}
