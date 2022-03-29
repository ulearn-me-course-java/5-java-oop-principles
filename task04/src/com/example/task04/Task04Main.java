package com.example.task04;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Time;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        Logger log1 = new Logger("log1", LEVEL.ERROR);
//        log1.addHandler(new ConsoleHandler());
        log1.addHandler(new MemoryHandler(4, new ConsoleHandler()));
        for (int i = 0; i < 5; i++) {
            System.out.printf("Name logger: %s. Level: %s. \n", log1.getName(), log1.getLevel().name());
            log1.debug("Test Debug " + i);
            log1.info("Test Info " + i);
            log1.error("Test Error " + i);
            log1.setLevel(LEVEL.INFO);
        }
//        log1.addHandler(new FileHandler(Paths.get(System.getProperty("user.home") + File.separator + "Log.txt")));
//        log1.addHandler(new RotationFileHandler(Paths.get(System.getProperty("user.home") + File.separator + "Logs"), new Time(3)));
//        for (int i = 0; i < 8; i++){
//            log1.error("Test Error " + i);
//        }
    }
}
