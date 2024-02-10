package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Task04Main {
    public static void main(String[] args) {

        ArrayList<MessageHandler> handlers = new ArrayList<>();

        handlers.add(new ConsoleHandler());
        handlers.add(new FileHandler());
        handlers.add(new MemoryHandler(5, handlers));
        handlers.add(new RotationFileHandler(ChronoUnit.SECONDS));

        Logger infoLogger = new Logger("forInfo", handlers);
        Logger warningLogger = new Logger("forWarning", Level.WARNING, handlers);

        infoLogger.info("This is info log");
        warningLogger.warning("Your brain bomb activated");
    }
}