package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("logger-1",
                new ConsoleHandler(),
                new FileHandler("logFile-2"),
                new RotationFileHandler("logFile-1", ChronoUnit.MINUTES));
        logger.error("error!!");

        logger.warning("warning!");
    }
}
