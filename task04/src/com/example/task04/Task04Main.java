package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("Valera", new ConsoleHandler(), new MemoryHandler(70));
        logger.debug("pipa is the best");
    }
}
