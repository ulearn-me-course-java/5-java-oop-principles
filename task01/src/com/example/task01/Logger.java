package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private final String name;
    private static HashMap<String, Logger> existLoggers = new HashMap<>();
    private Level level;

    private Logger(String name) {
        this.name = name;
    }

    public static Logger getLogger(String name) {
        return existLoggers.containsKey(name) ? existLoggers.get(name) : new Logger(name);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level lvl) {
        this.level = lvl;
    }

    public Level getLevel() {
        return level;
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
        log(Level.DEBUG, format, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... args) {
        log(Level.DEBUG, format, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String format, Object... args) {
        log(Level.DEBUG, format, args);
    }

    public void log(Level lvl, String message) {
        if (lvl.ordinal() < level.ordinal()) return;
        SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.printf("[%s] %s %s - %s%n", level, dt.format(new Date()), name, message);
    }

    public void log(Level lvl, String format, Object... args) {
        log(level, String.format(format, args));
    }

}
