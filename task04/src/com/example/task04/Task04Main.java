package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args){
        RotationFileHandler ff = new RotationFileHandler(ChronoUnit.MILLIS);
        FileHandler fileHandler = new FileHandler();
        ConsoleHandler consoleHandler = new ConsoleHandler();

        Logger log1 = new Logger("name1", ImportanceLevel.INFO, new MessageHandler() {
            @Override
            public void handleMessage(String message) {
                System.out.println(message);
            }
        });

        Logger log2 = new Logger("name2", ImportanceLevel.DEBUG, ff, fileHandler, consoleHandler, message -> System.out.println(message));

        log2.log(ImportanceLevel.INFO, "%s %d", "mes", 5);
        RotationFileHandler rr = new RotationFileHandler(ChronoUnit.SECONDS);
        rr.handleMessage("%d - %s", 1, "yes");
        MemoryHandler mm = new MemoryHandler(3, new MemoryHandler(2, new ConsoleHandler()), new FileHandler());
        mm.handleMessage("hi");
        mm.handleMessage("bye");
        mm.handleMessage("yes");
        mm.handleMessage("gjrf");
    }
}
