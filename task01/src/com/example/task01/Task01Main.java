package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger l1 = new Logger("123");
        Logger l3 = Logger.getLogger("123");
        System.out.println(l1 == l3);
    }
}
