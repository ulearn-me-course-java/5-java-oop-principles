package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger=new Logger("consLog", new ConsoleHandler());
        System.out.println(logger.getName());
        logger.debug("heeeeeelp");
        logger.error("meeeeeeeee");
        logger.setLevel(Logger.Levels.ERROR);
        logger.debug("you don`t see me");
    }
}
