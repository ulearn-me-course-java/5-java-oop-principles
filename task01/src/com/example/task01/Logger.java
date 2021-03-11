package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.*;

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {

    private final static HashMap<String, Logger> hashMap = new HashMap<>();
    private Level level = Level.DEBUG;
    private final String name;

    public Logger(String name) {
        this.name = name;
        hashMap.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return hashMap.containsKey(name) ? hashMap.get(name) : new Logger(name);
    }

    public void setLevel(String newLevel) {
        level = Level.valueOf(newLevel);
    }

    public String getLevel() {
        return String.valueOf(level);
    }

    private void log(Level level, String message) {
        if (!(level.ordinal() >= this.level.ordinal())) return;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.printf("[%s] %s %s - %s", level, dateFormat.format(new Date()), name, message);
    }

    private void log(Level level, String message, Object... args) {
        log(level, String.format(message, args));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(Level.DEBUG, message, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(Level.WARNING, message, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(Level.ERROR, message, args);
    }

}