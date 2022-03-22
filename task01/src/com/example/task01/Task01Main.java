package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger log;
        for(int i = 0; i < 10; i++)
         log = new Logger("name" + i, Important.INFO, "mess");
        for(int i = 10; i < 20; i++)
            log = new Logger("name" + i, Important.WARNING, "mess");
        for(int i = 20; i < 30; i++)
            log = new Logger("name" + i, Important.ERROR, "mess");
        Logger.setLevel(Important.INFO);
        System.out.println(Logger.getLogs());

        System.out.println();

        Logger.warning("CHANGE");
        Logger.log(Important.ERROR, "CHANGE!!!");
        System.out.println(Logger.getLogs());
    }
}
