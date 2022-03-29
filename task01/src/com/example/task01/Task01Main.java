package com.example.task01;

import java.util.ArrayList;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test1");
        Logger logger2 = Logger.getLogger("test1");
        System.out.println(logger1 == logger2);
    }
}
