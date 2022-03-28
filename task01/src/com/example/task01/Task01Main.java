package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger0 = new Logger("l0");
        Logger logger1 = new Logger("l1");

        Logger logger2 = Logger.getLogger("l0");
        Logger logger3 = Logger.getLogger("l0");

        System.out.println(logger2 == logger3);
    }
}
