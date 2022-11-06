package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {

    final private String name;
    private LoggerLevel level;
    final static private HashMap<String, Logger> loggers = new HashMap<String, Logger>();

    public Logger(String name) {
        this.name = name;
        this.level = LoggerLevel.INFO;
        loggers.put(name, this);
    }

    public void setLevel(LoggerLevel level) {
        this.level = level;
    }

    public LoggerLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        if (logger != null) return logger;
        else return new Logger(name);
    }

    public void debug(String message) {
        log(LoggerLevel.DEBUG, message);
    }

    public void debug(String form, Object... args) {
        log(LoggerLevel.DEBUG, form, args);
    }

    public void info(String message) {
        log(LoggerLevel.INFO, message);
    }

    public void info(String form, Object... args) {
        log(LoggerLevel.INFO, form, args);
    }

    public void warning(String message) {
        log(LoggerLevel.WARNING, message);
    }

    public void warning(String form, Object... args) {
        log(LoggerLevel.WARNING, form, args);
    }

    public void error(String message) {
        log(LoggerLevel.ERROR, message);
    }

    public void error(String form, Object... args) {
        log(LoggerLevel.ERROR, form, args);
    }

    private void log(LoggerLevel level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} {4} - {5}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")),
                    this.name,
                    message));
        }
    }

    private void log(LoggerLevel level, String form, Object... args) {
        System.out.println(MessageFormat.format(form, args));
    }
}
