package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Logger {

    private final String name;
    private Level level;
    private static HashMap<String, Logger> loggers;

    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name)) return loggers.get(name);
        return new Logger(name);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String sample, Object... args) {
        log(Level.DEBUG, sample, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String sample, Object... args) {
        log(Level.INFO, sample, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String sample, Object... args) {
        log(Level.WARNING, sample, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String sample, Object... args) {
        log(Level.ERROR, sample, args);
    }

    private void log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(LocalDateTime.now()), name, message));
    }

    private void log(Level level, String sample, Object... args) {
        log(level, MessageFormat.format(sample, args));
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}
