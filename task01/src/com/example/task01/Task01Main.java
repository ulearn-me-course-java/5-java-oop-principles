package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test", Level.INFO);
        Logger logger2 = new Logger("test");
        Logger logger3 = Logger.getLogger("test");
    }
}