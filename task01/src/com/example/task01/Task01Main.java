package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("Ivan");
        logger.log(Level.DEBUG, "%s %d", "Me", 10);

        Logger logger1 = new Logger("Ivan");
        logger1.log(Level.INFO, "%s %d", "Me", 10);

        Logger logger2 = new Logger("Ivan");
        logger2.log(Level.WARNING, "%s %d", "Me", 10);

        Logger logger3 = new Logger("Ivan");
        logger3.log(Level.ERROR, "%s %d", "Me", 10);

    }
}
