package com.example.task04;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES) + ".txt");

        Logger logger = new Logger("CoolName");
        logger.addHandler(new ConsoleHandler());
        //logger.addHandler(new FileHandler());
        //logger.addHandler(new RotationFileHandler(ChronoUnit.MINUTES));
        logger.addHandler(new MemoryHandler(new FileHandler(),5));
        logger.setLevel(Level.INFO);
        logger.debug("debug");
        logger.info("info");
        logger.warning("warning");
        logger.error("error");
        logger.error("error2");
        logger.error("5 log should double logs");
        logger.error("6");

    }
}
