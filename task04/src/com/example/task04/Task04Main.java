package com.example.task04;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime nowHour = localDateTime.truncatedTo(ChronoUnit.HOURS);
        System.out.println(localDateTime);
        System.out.println(ChronoUnit.HOURS);
        System.out.println(nowHour.getHour());
        System.out.println(nowHour);

        FileHandler fileHandler = new FileHandler();
        fileHandler.handle("test");
        fileHandler.handle("test2");

        Logger logger1 = new Logger("logger1", ImportanceLevel.DEBUG, new FileHandler());
        Logger logger2 = new Logger("logger2", ImportanceLevel.DEBUG, new FileHandler());

        logger1.log(ImportanceLevel.DEBUG, "test1");
        logger1.log(ImportanceLevel.WARNING, "test2");

        logger1.setHandler(new MemoryHandler(2, new ConsoleHandler(), new RotationFileHandler(ChronoUnit.MINUTES)));
        logger1.debug("test1");
        logger1.debug("test2");
        Thread.sleep(2000);
        logger1.debug("test3");
        logger1.debug("test4");
    }
}
