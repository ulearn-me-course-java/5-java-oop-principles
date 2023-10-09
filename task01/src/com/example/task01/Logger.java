package com.example.task01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private final static HashMap<String, Logger> loggers = new HashMap<String, Logger>();
    private final String name;
    private Level level;

    public Logger(String name) {
        this.name = name;

        loggers.put(this.name, this);
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
        if (level.ordinal() <= this.level.ordinal()) {
            System.out.println(formatMessage(level, message));
        }
    }

    public void log(Level level, String format, Object... params) {
        log(level, String.format(format, params));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... params) {
        debug(String.format(format, params));
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String format, Object... params) {
        info(String.format(format, params));
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... params) {
        warning(String.format(format, params));
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String format, Object... params) {
        error(String.format(format, params));
    }

    private String formatMessage(Level level, String message) {
        return String.format("[%s] %s %s - %s",
                level,
                LocalDate.now().format(
                        DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")
                ),
                name,
                message
        );
    }
}
