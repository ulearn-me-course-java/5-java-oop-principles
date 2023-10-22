package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger log1 = new Logger("test");
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        Boolean b = (logger1 == logger2);
        System.out.println(b);
    }
}
