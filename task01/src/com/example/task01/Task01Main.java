package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("testLogger");
        logger.setLevel(Level.INFO);
        Logger.getLogger("testLogger").warning("(%s)(%s)", logger.getLevel(), logger.getName());
    }
}
