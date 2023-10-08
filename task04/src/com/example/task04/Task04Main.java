package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Task04Main {
    public static void main(String[] args) {
        ArrayList<MessageHandler> handlers = new ArrayList<>();

        handlers.add(new ConsoleHandler());
        handlers.add(new FileHandler());
        handlers.add(new RotationFileHandler(ChronoUnit.SECONDS));
        handlers.add(new MemoryHandler(5, handlers));

        Logger logger = new Logger("test", handlers);
        Logger logger2 = new Logger("test-2", LogLevel.DEBUG, handlers);

        logger.info("hihi haha!");
        logger2.debug("UFO has fallen lol");
    }
}
