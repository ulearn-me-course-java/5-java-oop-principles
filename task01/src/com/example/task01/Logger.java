package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    private static final Map<String, Logger> loggers = new HashMap<>();

    private final String name;
    private Level level = Level.INFO;

    private Logger(String name) {
        this.name = name;
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

    public void setLevel(Level level) {
        this.level = level;
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

    public void log(Level level, String message) {
        if (level.compareTo(this.level) >= 0) {
            System.out.println(formatMessage(level, message));
        }
    }
    public void log(Level level, String format, Object... args) {
        if (level.compareTo(this.level) >= 0) {
            System.out.println(formatMessage(level, String.format(format, args)));
        }
    }

    private String formatMessage(Level level, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());
        return String.format("[%s] %s %s %s - %s", level, date, time, name, message);
    }
}