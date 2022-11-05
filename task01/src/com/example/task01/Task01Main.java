package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("connectionLogger");
        logger.error("connection error, retry in 3,2,1...");
        logger.debug("debug started...");
        System.out.println(logger.getLevel());
        logger.setLevel(Level.INFO);
        System.out.println(logger.getLevel());
        logger.info("connected successfully!");
    }
}
