package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test");
        logger.setLevel(LogSeverityLvl.WARNING);
        logger.error("test message");
    }
}
