package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger l1 = Logger.getLogger("test");
        Logger l2 = Logger.getLogger("test");
        System.out.println(l1 == l2);
    }
}
