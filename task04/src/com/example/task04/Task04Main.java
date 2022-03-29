package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {

        MessageHandler handler = new ConsoleHandler();
        handler.log("ww");
        handler = new FileHandler();
        handler.log("abc");
        handler.log("abb");

        handler = new MemoryHandler(2, new RotationFileHandler(ChronoUnit.MILLIS));
        handler.log("a");
        handler.log("b");
        handler.log("c");
        handler.log("d");
    }
}
