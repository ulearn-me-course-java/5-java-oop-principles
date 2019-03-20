package com.example.task04;


import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.out;

public class Task04Main {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getLogger("test");
        Logger logger1 = Logger.getLogger("tesct");
        out.println(logger==logger1);
/*        logger.addHandler(new RotationFileHandler("smth.txt", ChronoUnit.SECONDS));
        logger.debug("first_message");
        Thread.sleep(2000);
        logger.debug("second_message");*/
    }
}
