package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("nya");
        Logger logger1 = Logger.getLogger("nya");
        Logger logger2 = Logger.getLogger("nya");
        System.out.println(logger1 == logger2);
    }
}
