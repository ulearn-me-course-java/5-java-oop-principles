package com.example.task01;

import java.io.Console;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

class Logger {
    private final String name;
    private importanceLevel level;
    private static HashMap<String,Logger> loggers = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        this.level = importanceLevel.DEBUG;
        loggers.put(name,this);
    }

    public Logger(String name, importanceLevel level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name))
            return loggers.get(name);
        return new Logger(name);
    }

    public String getName() {
        return this.name;
    }

    public void setLevel(importanceLevel level) {
        this.level = level;
    }

    public importanceLevel getLevel() {
        return level;
    }

    public void  log(importanceLevel level, String message) {
        printLog(level,message);
    }

    public void log(importanceLevel level, String template, Object... args) {
        printLog(level, template, args);
    }

    public void printLog(importanceLevel level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }

    public void printLog(importanceLevel level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(template, args));
        }
    }

    public void info(String message) {
        log(importanceLevel.INFO, message);
    }

    public void info(String template, Object... args) {
        log(importanceLevel.INFO, template, args);
    }

    public void debug(String message) {
        log(importanceLevel.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(importanceLevel.DEBUG, template, args);
    }

    public void warning(String message) {
        log(importanceLevel.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(importanceLevel.WARNING, template, args);
    }

    public void error(String message) {
        log(importanceLevel.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(importanceLevel.ERROR, template, args);
    }
}
