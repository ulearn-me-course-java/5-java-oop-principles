package com.example.task01;

public class Task01Main {

    public static void main(String[] args) {
        Logger logger = new Logger("Vlad");
        logger.log(Level.DEBUG, "%s %d", "Me", 10);
    }
}
