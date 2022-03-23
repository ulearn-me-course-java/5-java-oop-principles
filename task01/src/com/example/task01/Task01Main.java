package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getLogger("test1");
        Logger log2 = Logger.getLogger("test1");
        System.out.println(log1 == log2);
        log1.debug("message %d", 123);
        log1.error("message %d", 123);
        log1.log(Levels.DEBUG, "message %d", 123);
        System.out.println();
        log1.setLevel(Levels.DEBUG);
        log1.showLogMessage(Levels.DEBUG, "DEBUG!");
    }
}
