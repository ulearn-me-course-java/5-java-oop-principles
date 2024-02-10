package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private static ArrayList<MessageHandler> handlers = new ArrayList<>();
    private final String name;
    private PriorityLevel level;

    public Logger(String name){
        this.name = name;
        level = PriorityLevel.INFO;
        loggers.put(name, this);
        handlers.add(new ConsoleHandler());
    }

    public Logger(String name, ArrayList<MessageHandler> messageHandlers) {
        this.name = name;
        this.level = PriorityLevel.INFO;
        loggers.put(this.name, this);
        handlers = messageHandlers;
    }

    public Logger(String name, PriorityLevel level, ArrayList<MessageHandler> messageHandlers){
        this.name = name;
        this.level = level;
        loggers.put(name, this);
        handlers = messageHandlers;
    }

}