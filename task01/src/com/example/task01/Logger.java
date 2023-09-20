package com.example.task01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    public enum Level {
        DEBUG, INFO, WARNING, ERROR
    }

    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private Level level;

    public Logger(String name, Level level) {
        this.level = level;
        this.name = name;
        if (!loggers.containsKey(name)) {
            loggers.put(name, this);
        }
    }

    public Logger(String name) {
        this.level = Level.DEBUG;
        this.name = name;
        if (!loggers.containsKey(name)) {
            loggers.put(name, this);
        }
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        if (logger == null) {
            return new Logger(name);
        }
        return logger;
    }

    public String getName() {
        return name;
    }

    public void log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.printf("[%s] %s %s - %s%n",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message);
        }
    }

    public void log(Level level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.printf(template + "%n", args);
        }
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String template, Object... args) {
        log(Level.INFO, template, args);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(Level.DEBUG, template, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(Level.WARNING, template, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(Level.ERROR, template, args);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
