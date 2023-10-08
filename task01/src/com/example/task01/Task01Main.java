package com.example.task01;

import java.sql.Time;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test");
        logger.setLevel(Logger.Level.DEBUG);
        logger.debug("debug smth");
        logger.error("Database is not available now");
    }
}
