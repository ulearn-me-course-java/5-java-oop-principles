package com.example.task04;


import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {

        Logger logger = new Logger("text");
        logger.registeringHandler(new ConsoleHandler());
        logger.registeringHandler(new FileHandler("Message.txt"));
        logger.registeringHandler(new RotationFileHandler(ChronoUnit.SECONDS));
        logger.registeringHandler(new MemoryHandler(new ConsoleHandler(), 2));
        logger.log(Level.DEBUG, "value1");
        logger.log(Level.DEBUG, "value2");

    }
}
