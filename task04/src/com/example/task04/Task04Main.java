package com.example.task04;

import java.io.IOException;
import java.util.Calendar;

public class Task04Main
{
    public static void main(String[] args) throws IOException
    {
        Logger logger = new Logger("Logger", Level.Debug);
        logger.getHandlers().add(new ConsoleHandler());
        logger.getHandlers().add(new FileHandler("/home/Nanoster/testJava.txt"));
        logger.getHandlers().add(new RotationFileHandler(Calendar.HOUR, "/home/Nanoster/Java"));

        MemoryHandler handler = new MemoryHandler();
        handler.getHandlers().add(new ConsoleHandler());
        logger.getHandlers().add(handler);

        logger.log(Level.Error, "Aboba");
        logger.log(Level.Info, "Amogus");
        handler.log();
    }
}
