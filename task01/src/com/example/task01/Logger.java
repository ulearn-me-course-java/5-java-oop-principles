package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class Logger {
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private Level level;
    public Logger(String name) {
        this(name, Level.DEBUG);
    }
    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }
    public String getName() {
        return name;
    }
    public Level getLevel() {
        return level;
    }
    public static Logger getLogger(String name) {
        if(loggers.containsKey(name)) {
            return loggers.get(name);
        }
        return new Logger(name);
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public void log(Level level, String message) {
        if(level.ordinal() >= this.level.ordinal()) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            System.out.printf("[%s] %s %s - %s", level, formatter.format(date), name, message);
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

