package com.example.task01;

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

    public Logger() {
    }
    public Logger(String name) {
        if (name == null)
            throw new IllegalArgumentException("Имя не может быть null");
        else {
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
    public void debug(String message, String... f) {
        log(Level.DEBUG, message, f);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }
    public void info(String message, String... f) {
        log(Level.INFO, message, f);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }
    public void warning(String message, String... f) {
        log(Level.WARNING, message, f);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }
    public void error(String message, String... f) {
        log(Level.ERROR, message, f);
    }
    public void log(Level importanceLevel, String message) {
        if (importanceLevel.ordinal() >= level.ordinal()) {
            SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss ");
            System.out.printf("[%s] %s %s - %s%n", level, formatForDate.format(new Date()), name, message);
        }
    }
    public void log(Level importanceLevel, String template, Object... params) {
        log(importanceLevel, String.format(template, params));
    }
}
