package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String name;
    private importanceLevel lvl;
    private static Map<String, Logger> loggers = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        this.lvl = importanceLevel.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, importanceLevel lvl) {
        this.name = name;
        this.lvl = lvl;
        loggers.put(name, this);
    }

    public String getName() {
        return name;
    }

    public importanceLevel getLevel() {

        return lvl;
    }

    public void setLevel(importanceLevel lvl) {
        this.lvl = lvl;
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        }
        return new Logger(name);
    }

    public void info(String message) {
        log(importanceLevel.INFO, message);
    }

    public void info(String message, Object... params) {
        log(importanceLevel.INFO, message, params);
    }

    public void debug(String message) {
        log(importanceLevel.DEBUG, message);
    }

    public void debug(String message, Object... params) {
        log(importanceLevel.DEBUG, message, params);
    }

    public void warning(String message) {
        log(importanceLevel.WARNING, message);
    }

    public void warning(String message, Object... params) {
        log(importanceLevel.WARNING, message, params);
    }

    public void error(String message) {
        log(importanceLevel.ERROR, message);
    }

    public void error(String message, Object... params) {
        log(importanceLevel.ERROR, message, params);
    }

    public void log(importanceLevel lvl, String name) {
        logMessage(lvl, name);
    }

    public void log(importanceLevel lvl, String name, Object... params) {
        logMessage(lvl, name, params);
    }



    private void logMessage(importanceLevel lvl, String message) {
        if (lvl.ordinal() >= this.lvl.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    lvl,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }

    private void logMessage(importanceLevel lvl, String message, Object... params) {
        if (lvl.ordinal() >= this.lvl.ordinal()) {
            System.out.println(MessageFormat.format(message, params));
        }
    }
}
