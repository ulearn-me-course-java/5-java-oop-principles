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
        Logger logger2 = new Logger("secondTest", Level.WARNING, handlers);

        logger.info("ORA ORA ORA ORA");
        logger2.warning("MUDA MUDA MUDA MUDA");
    }
}
