package com.example.task01;



public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = new Logger("test1");
        System.out.println(logger1.getLevel());
        logger1.setLevel(Logger.Level.WARNING);
        logger1.log(Logger.Level.WARNING, "warn");
        Logger logger2 = new Logger("test2");
        logger2.setLevel(Logger.Level.ERROR);
        System.out.println(logger2.getLevel());
        logger2.log(Logger.Level.ERROR, "fail");

    }
}
