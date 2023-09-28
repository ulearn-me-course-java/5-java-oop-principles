package com.example.task04;

import com.example.task04.handler.ConsoleHandler;
import com.example.task04.handler.MemoryHandler;

public class Task04Main {
    public static void main(String[] args) {
        MemoryHandler handler = new MemoryHandler(10, new ConsoleHandler());
        Logger logger = new Logger("test", handler);
        for (int i = 0; i < 15; i++) {
            logger.log(LogLevels.DEBUG, "test message" + (i + 1));
        }
        handler.freeMemory();
        System.out.println("Finished");
    }
}
