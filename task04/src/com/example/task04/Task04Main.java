package com.example.task04;

import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        ArrayList<MessageHandler> handlersWithoutMemory = new ArrayList<>();
        handlersWithoutMemory.add(new ConsoleHandler());
        handlersWithoutMemory.add(new FileHandler());
        handlersWithoutMemory.add(new RotationFileHandler(ChronoUnit.MINUTES));

        ArrayList<MessageHandler> handlers = new ArrayList<>();
        handlers.add(new ConsoleHandler());
        handlers.add(new FileHandler());
        handlers.add(new RotationFileHandler(ChronoUnit.SECONDS));
        handlers.add(new MemoryHandler(5, handlersWithoutMemory));

        Logger log1 = new Logger("1", handlers);
        Logger log2 = new Logger("2", LoggerLevel.DEBUG, handlers);

        log1.info("work it");
        log2.error("is working");
        log1.info("work it");
        log2.error("is working");
        log1.info("work it");
    }
}
