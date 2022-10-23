package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private String name;
    private Level level;
    private static HashMap<String, Logger> loggers = new HashMap<>();

    public Logger(String name) {
        if (name == null)
            throw new IllegalArgumentException("Имя не может быть null");
        else {
            loggers.put(name, this);
            this.name = name;
            level = Level.DEBUG;
        };
    }
    public static Logger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            loggers.put(name, new Logger(name));
        }
        return loggers.get(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public Level getLevel() {
        return level;
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }
    public void debug(String message, Object... params) {
        log(Level.DEBUG, message, params);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }
    public void info(String message, Object... params) {
        log(Level.INFO, message, params);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }
    public void warning(String message, Object... params) { log(Level.WARNING, message, params); }

    public void error(String message) {
        log(Level.ERROR, message);
    }
    public void error(String message, Object... params) {
        log(Level.ERROR, message,params);
    }

    public void log(Level level, String message){
        if(level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
    }
    public void log(Level importanceLevel, String template, Object... params) {
        log(importanceLevel, String.format(template, params));
    }
}
