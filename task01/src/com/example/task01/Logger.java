package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private LoggerLevel loggerLevel;

    public Logger(String name, LoggerLevel logLevel) {
        this.name = name;
        loggerLevel = logLevel;
        loggers.put(name, this);
    }

    public Logger(String name) {
        this.name = name;
        loggerLevel = LoggerLevel.INFO;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        if (logger == null) {
            logger = new Logger(name);
        }
        return logger;
    }

    public LoggerLevel getLevel() {
        return loggerLevel;
    }

    public String getName() {
        return name;
    }

    public void setLevel(LoggerLevel logLevel) {
        this.loggerLevel = logLevel;
    }

    public void log(LoggerLevel level, String message) {
        outputMessage(level, message);
    }

    public void log(LoggerLevel level, String template, Object... args) {
        outputMessage(level, template, args);
    }

    public void info(String message) {
        log(loggerLevel.INFO, message);
    }

    public void info(String template, Object... args) {
        log(loggerLevel.INFO, template, args);
    }

    public void debug(String message) {
        log(loggerLevel.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(loggerLevel.DEBUG, template, args);
    }

    public void error(String message) {
        log(loggerLevel.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(loggerLevel.ERROR, template, args);
    }

    public void warning(String message) {
        log(loggerLevel.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(loggerLevel.WARNING, template, args);
    }

    public void outputMessage(LoggerLevel level, String message) {
        if (level.ordinal() >= this.loggerLevel.ordinal()) {
            String messageOut = MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.mm.dd hh:mm:ss")),
                    this.name,
                    message);
            System.out.println(messageOut);
        }
    }

    public void outputMessage(LoggerLevel level, String template, Object... args) {
        if (level.ordinal() >= this.loggerLevel.ordinal()) {
            System.out.println(MessageFormat.format(template, args));
        }
    }
}
