package com.example.task04;

import java.nio.file.Paths;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("testLogger");
        logger.setLevel(Level.INFO);
        System.out.println(System.getProperty("user.dir") + "\\psKillMe");

        /*logger.addHandler(new RotationFileHandler(Paths.get(System.getProperty("user.dir") + "\\Logs"),new Time(2)));
        for (int i = 0; i < 5; i++)
            logger.log(Level.WARNING,"testMessage" + i);*/

        logger.addHandler(new MemoryHandler(3, new ConsoleHandler()));
        logger.addHandler(new FileHandler(Paths.get(System.getProperty("user.dir") + "\\Log")));
        for (int i = 0; i < 8; i++)
            logger.log(Level.WARNING, "testMessage" + i);
    }
}
