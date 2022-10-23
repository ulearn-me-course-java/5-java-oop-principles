package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {

        Logger logger = new Logger("test");

        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        boolean f =  logger1 == logger2;

        System.out.println(f);
    }
}
