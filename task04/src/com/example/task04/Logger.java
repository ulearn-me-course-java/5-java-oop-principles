package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    private Level level;
    private final String name;
    private static final java.util.Map<String, Logger> LOGGERS = new HashMap<>();
    private final ArrayList<MessageHandler> handlers = new ArrayList<>();

    private Logger(String name) {
        this.name = name;
        level = Level.DEBUG;
    }

    public static Logger getLogger(String name) {
        if (LOGGERS.containsKey(name)) {
            return LOGGERS.getOrDefault(name, null);
        } else {
            Logger newLogger = new Logger(name);
            LOGGERS.put(name, newLogger);
            return newLogger;
        }
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

    public void addHandler(MessageHandler handler){
        handlers.add(handler);
    }

    private String formMessage(Level level, String text) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        return String.format("[%s] %s %s - %s", level.name(), dateFormat.format(date), name, text);
    }

    public void log(Level level, String message) {
        if (level.compareTo(this.level) >= 0){
            String logMessage = formMessage(level, message);
            for(MessageHandler handler: handlers){
                handler.logMessage(logMessage);
            }
        }
    }
    public void log(Level level, String format, Object... args) {
        log(level,String.format(format, args));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }
    public void debug(String format, Object... args) {
        log(Level.DEBUG, format, args);
    }
    public void info(String message) {
        log(Level.INFO, message);
    }
    public void info(String format, Object... args) {
        log(Level.INFO, format, args);
    }
    public void warning(String message) {
        log(Level.WARNING, message);
    }
    public void warning(String format, Object... args) {
        log(Level.WARNING, format, args);
    }
    public void error(String message) {
        log(Level.ERROR, message);
    }
    public void error(String format, Object... args) {
        log(Level.ERROR, format, args);
    }
}

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}