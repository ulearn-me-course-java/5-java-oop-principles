package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("MLogger");

        logger.addHandler(new ConsoleHandler());
        logger.addHandler(new ConsoleHandler());

        logger.log(MessageLevel.DEBUG, "Simple message");
    }
}
