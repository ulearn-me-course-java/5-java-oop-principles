package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        MessageHandler[] handlers = new MessageHandler[] {
                new ConsoleHandler(),
                new MemoryHandler(5)
        };
        Logger logger = new Logger("pyp", handlers);
    }
}
