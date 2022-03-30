package com.example.task04;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Logger
{
    private static final Dictionary<String, Logger> loggers = new Hashtable<>();

    public static Logger getLogger(String name)
    {
        return loggers.get(name);
    }

    private final String name;
    private Level mainLevel;
    private final Message message;
    private final ArrayList<MessageHandler> handlers = new ArrayList<>();

    public Logger(String name, Level mainLevel)
    {
        this.name = name;
        message = new Message(mainLevel, name);
        this.mainLevel = mainLevel;
        loggers.put(name, this);
    }

    private void logMessage(String message)
    {
        for (MessageHandler handler : handlers)
        {
            handler.Handle(message);
        }
    }

    public String getName()
    {
        return name;
    }

    public void setMainLevel(Level mainLevel)
    {
        this.mainLevel = mainLevel;
    }

    public void log(Level level, String inputStr)
    {
        if (level.compareTo(this.mainLevel) < 0) return;
        message.setLevel(level);
        String finalStr = message.getMessage(inputStr);
        logMessage(finalStr);
    }

    public void log(Level level, String format, Object... variables)
    {
        if (level.compareTo(this.mainLevel) < 0) return;
        message.setLevel(level);
        String finalStr = message.getMessage(format, variables);
        logMessage(finalStr);
    }

    public ArrayList<MessageHandler> getHandlers()
    {
        return handlers;
    }
}
