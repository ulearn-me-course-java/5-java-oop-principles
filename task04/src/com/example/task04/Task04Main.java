package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Task04Main {
    public static void main(String[] args) {

        ArrayList<MessageHandler> handlerNotMemory = new ArrayList<>();
        ArrayList<MessageHandler> allHandlers = new ArrayList<>();

        handlerNotMemory.add(new RotationFileHandler(ChronoUnit.HOURS));
        handlerNotMemory.add(new ConsoleHandler());

        allHandlers.add(new RotationFileHandler(ChronoUnit.SECONDS));
        allHandlers.add(new FileHandler());
        allHandlers.add(new MemoryHandler(9, handlerNotMemory));

        Logger loggerTest1 = new Logger("testONE", LoggerLevel.ERROR, allHandlers);
        Logger logerTest2 = new Logger("testTWO", allHandlers);

        logerTest2.info("info is good");
        loggerTest1.error("anywhere was breaking");
        logerTest2.warning("??????");

    }
}
