package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {

        Logger l = new Logger("test");
        l.setLevel(Logger.Level.ERROR);
        l.AddHandler(new ConsoleHandler());
        l.AddHandler(new FileHandler("test"));
        l.AddHandler(new RotationFileHandler(ChronoUnit.HOURS));

        l.error("test");
        l.info("test");

    }
}
