package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.registerLogger(new ConsoleLogger());
        logger.registerLogger(new FileLogger("logFile"));
        logger.registerLogger(new RotationLogger());
        logger.registerLogger(new MemoryLogger(new ConsoleLogger()));

        logger.log(Level.DEBUG, "meme");
        logger.log(Level.DEBUG, "meme");
    }
}
