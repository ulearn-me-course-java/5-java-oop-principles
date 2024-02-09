package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger Logger = new Logger("fd");
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        Logger Logger3 = new Logger("test");
    }
}