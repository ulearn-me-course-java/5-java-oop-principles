package com.example.task04;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Logger logger1 = Logger.getLogger("logger");
        logger1.addHandler(new MemoryHandler(new FileHandler("C:/javalog/mem.txt"), 5));
        logger1.addHandler(new RotationFileHandler("C:/javalog/rfh", "yyyy_MM_dd_hh_mm", ChronoUnit.MINUTES));

        logger1.debug("some message 1");
        logger1.info("some message 1");
        logger1.warning("some message 1");
        logger1.error("some message 1");

        Thread.sleep(70000); //10000 -  10 s

        logger1.addHandler(new FileHandler("C:/javalog/fh.txt"));
        logger1.log(Logger.Level.DEBUG, "file handler test");
        logger1.log(Logger.Level.DEBUG, "0x%x: %s", 0x1223, "file handler test");

        Thread.sleep(70000); //10000 -  10 s

        logger1.log(Logger.Level.DEBUG, "RotationFileHandler test");
        logger1.log(Logger.Level.DEBUG, "0x%x: %s", 0x1223, "RotationFileHandler test");
    }
}