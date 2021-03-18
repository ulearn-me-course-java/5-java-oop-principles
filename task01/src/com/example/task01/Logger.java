package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private LogLevel level = LogLevel.INFO;

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
    }

    public Logger(String name) {
        this.name = name;
    }

    public static Logger getLogger(String name) {
        return loggers.containsKey(name) ? loggers.get(name) : new Logger(name);
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    private void log(LogLevel level, String message) {
        writeMessage(level, message);
    }

    private void log(LogLevel level, String message, Object... params) {
        writeMessage(level, String.format(message, params));
    }

    private void writeMessage(LogLevel level, String message) {
        if (level.ordinal() >= this.level.ordinal())
            System.out.println(String.format("[%s] %s %s - %s", level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String message, Object... params) {
        error(String.format(message, params));
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String message, Object... params) {
        warning(String.format(message, params));
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String message, Object... params) {
        warning(String.format(message, params));
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String message, Object... params) {
        warning(String.format(message, params));
    }
}
