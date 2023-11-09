package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger10 = Logger.getLogger("test");
        Logger logger20 = Logger.getLogger("test");
        System.out.println(logger10 == logger20);

    }
}