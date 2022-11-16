package com.example.task04;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        MemoryHandler ch = new MemoryHandler(new RotationFileHandler("C:\\Users\\viki2\\Desktop\\", ChronoUnit.MINUTES), 3);
        Logger lg = new Logger("pupunya", ch);
        lg.setLevel(Level.WARNING);
        lg.error("my cat is bad");
        lg.error("but i love my cat");
        lg.error("my cat");
        lg.error("love");
    }
}
