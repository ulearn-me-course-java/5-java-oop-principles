package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        ConsoleHandler ch = new ConsoleHandler();
        //MemoryHandler ch = new MemoryHandler(new RotationFileHandler("I:\\JavaTest\\", ChronoUnit.HOURS), 3);
        //FileHandler ch = new FileHandler("I:\\JavaTest\\test.txt");
        //RotationFileHandler ch = new RotationFileHandler("I:\\JavaTest\\", ChronoUnit.HOURS);
        Logger lg = new Logger("myLogger", ch);
        lg.setLevel(Logger.Level.WARNING);
        lg.error("first");
        lg.error("second");
        lg.error("third");
        lg.error("A a a");
        lg.error("B b b");
    }
}
