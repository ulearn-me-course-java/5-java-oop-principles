package com.example.task01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    public static Logger getLogger(String name) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        } else {
            return new Logger(name);
        }
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private LogLevels level = LogLevels.DEBUG;

    public LogLevels getLevel() {
        return level;
    }

    public void setLevel(LogLevels level) {
        this.level = level;
    }

    public Logger(String name) {
        this.name = name;
        loggers.put(this.name, this);
    }

    public void debug(String message) {
        log(LogLevels.DEBUG, message);
    }

    public void debug(String format, Object... params) {
        debug(String.format(format, params));
    }

    public void info(String message) {
        log(LogLevels.INFO, message);
    }

    public void info(String format, Object... params) {
        info(String.format(format, params));
    }

    public void warning(String message) {
        log(LogLevels.WARNING, message);
    }

    public void warning(String format, Object... params) {
        warning(String.format(format, params));
    }

    public void error(String message) {
        log(LogLevels.ERROR, message);
    }

    public void error(String format, Object... params) {
        error(String.format(format, params));
    }

    public void log(LogLevels level, String message) {
        if (level.ordinal() < this.level.ordinal()) {
            return;
        }
        System.out.println("[" + level + "] "
                + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"))
                + " " + this.name + " - " + message);
    }

    public void log(LogLevels level, String format, Object... params) {
        log(level, String.format(format, params));
    }
}