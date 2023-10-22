package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private ArrayList<MessageHandler> handlers = new ArrayList<>();
    private String name;
    private Level level;
    public Logger(String name, Level level, MessageHandler ...handlers) {
        this.name = name;
        this.level = level;
        for(MessageHandler handler : handlers) {
            this.handlers.add(handler);
        }
        loggers.put(name, this);
    }
    public Logger(String name, MessageHandler ...handlers) {
        this(name, Level.DEBUG, handlers);
    }
    public String getName() {
        return name;
    }
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        if(loggers.containsKey(name)) {
            return loggers.get(name);
        }
        return new Logger(name);
    }

    public void log(Level level, String message) {
        if(level.ordinal() >= this.level.ordinal()) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String logMessage = String.format("[%s] %s %s - %s", level, formatter.format(date), name, message);
            for (MessageHandler handler : handlers) {
                handler.log(logMessage);
            }
        }
    }
    public void log(Level level, String sample, Object ...objects) {
        log(level, String.format(sample, objects));
    }
    public void debug(String message) {
        log(Level.DEBUG, message);
    }
    public void debug(String sample, Object ...objects) {
        log(Level.DEBUG, String.format(sample, objects));
    }
    public void info(String message) {
        log(Level.INFO, message);
    }
    public  void info(String sample, Object ...objects) {
        log(Level.INFO, String.format(sample, objects));
    }
    public void warning(String message) {
        log(Level.WARNING, message);
    }
    public  void warning(String sample, Object ...objects) {
        log(Level.WARNING, String.format(sample, objects));
    }
    public void error(String message) {
        log(Level.ERROR, message);
    }
    public  void error(String sample, Object ...objects) {
        log(Level.ERROR, String.format(sample, objects));
    }
}
