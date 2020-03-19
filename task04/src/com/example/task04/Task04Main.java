package com.example.task04;

import com.example.task04.handlers.*;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("default");

        // logger.handleWith(new ConsoleHandler());
        // logger.handleWith(new MemoryHandler(new ConsoleHandler()));
        // logger.handleWith(new FileHandler());
        logger.handleWith(new RotationFileHandler(1, ChronoUnit.MINUTES));

        while (true) {
            try {
                logger.debug("Message");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
