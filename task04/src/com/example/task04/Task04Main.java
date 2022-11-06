package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Task04Main {
    public static void main(String[] args) {
        //FileHandler f =new FileHandler();
        //f.log("No Exception");
        //f.log("51116151");
        //RotationFileHandler r = new RotationFileHandler();
        //r.setRotation(ChronoUnit.SECONDS);
        //r.log("fjfjfjfjfj");

        ConsoleHandler c = new ConsoleHandler();
        c.log("round 1");
        FileHandler f =new FileHandler("file FileHendler.txt");
        f.log("round 2");
        RotationFileHandler r = new RotationFileHandler("RotFileHendler", ChronoUnit.DAYS);
        r.log("round 3");
        MemoryHandler memory = new MemoryHandler(2, c, f, r);
        memory.log("1");
        memory.log("2");
        memory.log("3");

    }
}
