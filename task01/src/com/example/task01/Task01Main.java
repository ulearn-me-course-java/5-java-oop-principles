package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("MLogger");
        logger.log(MessageLevel.DEBUG, "Simple message");
        Logger.getLogger("MLogger");
    }
}
