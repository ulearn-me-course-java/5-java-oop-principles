package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        MessageHandler handler = new ConsoleHandler();
        handler.log("ffff");
        handler = new FileHandler();
        handler.log("ffd");
        handler.log("ffc");
/*
        handler = new RotationFileHandler(ChronoUnit.MILLIS);
        handler.log("1");
        handler.log("2");
        handler.log("3");
     */
        handler = new MemoryHandler(2, new RotationFileHandler(ChronoUnit.MILLIS));
        handler.log("1");
        handler.log("2");
        handler.log("3");
        handler.log("4");
        handler.log("5");

    }
}
