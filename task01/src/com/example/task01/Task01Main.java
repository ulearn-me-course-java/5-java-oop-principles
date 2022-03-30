package com.example.task01;

public class Task01Main
{
    public static void main(String[] args)
    {
        Logger logger = new Logger("FirstLogger", Level.Debug);
        Logger logger2 = Logger.getLogger("FirstLogger");
        logger.log(Level.Info, String.valueOf(logger == logger2));
    }
}
