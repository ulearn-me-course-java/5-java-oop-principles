package com.example.task01;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String name;
    private LogLevel level;
    private static Map<String, Logger> loggers = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        this.level = LogLevel.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        if(loggers.containsKey(name))
            return loggers.get(name);
        return new Logger(name);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String message, Object... params) {
        log(LogLevel.INFO, message, params);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String message, Object... params) {
        log(LogLevel.DEBUG, message, params);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String message, Object... params) {
        log(LogLevel.WARNING, message, params);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String message, Object... params) {
        log(LogLevel.ERROR, message, params);
    }

    public void log(LogLevel level, String message) {
        logMassage(level, message);
    }

    public void log(LogLevel level, String message, Object... params) {
        logMassage(level, message, params);
    }

    private void logMassage(LogLevel level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }
    private void logMassage(LogLevel level, String message, Object... params) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(message, params));
        }
    }
}

