package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("logger-1");
        logger.AddHandler(new ConsoleHandler());
        logger.AddHandler(new FileHandler("logFile-2"));
        logger.AddHandler(new RotationFileHandler(ChronoUnit.MINUTES));
        logger.AddHandler(new MemoryHandler(3));

        logger.error("error!!");
        logger.warning("warning!");
        logger.debug("warning!");
    }
}
