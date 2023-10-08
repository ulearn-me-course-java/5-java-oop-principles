package com.example.task01;

import java.time.LocalDateTime;
import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private LogLevel logLevel;

    public Logger(String name, LogLevel level){
        this.name = name;
        logLevel = level;
        loggers.put(name, this);
    }

    public Logger(String name){
        this.name = name;
        logLevel = LogLevel.INFO;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name) {
        if (loggers.get(name) == null)
            loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public LogLevel getLevel() {
        return logLevel;
    }

    public String getName() {
        return name;
    }

    public void setLevel(LogLevel level) {
        this.logLevel = level;
    }
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String format, Object... objects) {
        log(LogLevel.INFO, format, objects);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String format, Object... objects) {
        log(LogLevel.DEBUG, format, objects);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String message, Object... objects) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String format, Object... objects) {
        log(LogLevel.ERROR, format, objects);
    }

    public void log(LogLevel level, String message) {
        if(this.logLevel.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printedMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, name, message);
            System.out.println(printedMessage);
        }
    }

    public void log(LogLevel level, String format, Object... objects) {
        if(logLevel.ordinal() <= level.ordinal())
            System.out.println(MessageFormat.format(format, objects));
    }
}
