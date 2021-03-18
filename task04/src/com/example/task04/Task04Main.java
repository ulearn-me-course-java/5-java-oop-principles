package com.example.task04;

import java.time.Duration;

public class Task04Main {
    public static void main(String[] args) {
        FileHandler f = new FileHandler("mes");
        f.log(Level.ERROR, "test message");
        f.log(Level.DEBUG, "next message");
        RotationFileHandler rf = new RotationFileHandler("newName", Duration.ofSeconds(600));
        rf.error("error test message");
        MemoryHandler m1 = new MemoryHandler("m1", 2);
        m1.error("Hello");
        m1.error("World!");
        m1.debug(":)");
    }
}
