package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = new Logger("log1");
        Logger logger2 = new Logger("log2");
        logger1.setLevel(Level.WARNING);
        logger2.setLevel(Level.DEBUG);
        logger1.info("low level test");//не выводится т.к. уровень меньше
        logger2.error("up level test");//выводится
    }
}

