package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("logger-1");

        logger.AddHandler(new MemoryHandler((x)-> System.out.println(x)));

        logger.error("error!!");
        logger.warning("warning!");
        logger.warning("warning!");
        logger.warning("warning!");
    }
}
