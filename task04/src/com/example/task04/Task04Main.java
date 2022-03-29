package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        MessageHandler handler = new ConsoleHandler();
        handler.logMessage("ffff");

        handler = new FileHandler();
        handler.logMessage("ffd");
        handler.logMessage("ffc");

        handler = new RotationFileHandler(ChronoUnit.MILLIS);
        handler.logMessage("1");
        handler.logMessage("2");
        handler.logMessage("3");

        handler = new MemoryHandler(new RotationFileHandler(ChronoUnit.MILLIS), 2);
        handler.logMessage("a");
        handler.logMessage("b");
        handler.logMessage("c");
        handler.logMessage("d");
        handler.logMessage("e");

    }
}
