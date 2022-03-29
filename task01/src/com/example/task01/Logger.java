package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Hashtable;

public class Logger {
    private LogLevel minimumLogLevel = LogLevel.INFO;
    private final String name;
    private static final Hashtable<String, Logger> loggers = new Hashtable<String, Logger>();

    public static Logger getLogger(String name) {
        return loggers.containsKey(name) ? loggers.get(name) : new Logger(name);
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return minimumLogLevel;
    }
    public void setLevel(LogLevel LogLevel) {
        minimumLogLevel = LogLevel;
    }

    private void logWithLevel(LogLevel level, String message) {
        if (message != null && minimumLogLevel.compareTo(level) <= 0) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                    name,
                    message));
        }
    }


    public void verbose(String message, Object... args) {
        logWithLevel(LogLevel.VERBOSE, String.format(message, args));
    }
    public void verbose(String message) {
        logWithLevel(LogLevel.VERBOSE, message);
    }

    public void debug(String message, Object... args) {
        logWithLevel(LogLevel.DEBUG, String.format(message, args));
    }
    public void debug(String message) {
        logWithLevel(LogLevel.DEBUG, message);
    }

    public void info(String message, Object... args) {
        logWithLevel(LogLevel.INFO, String.format(message, args));
    }
    public void info(String message) {
        logWithLevel(LogLevel.INFO, message);
    }

    public void warning(String message, Object... args) {
        logWithLevel(LogLevel.WARNING, String.format(message, args));
    }
    public void warning(String message) {
        logWithLevel(LogLevel.WARNING, message);
    }

    public void error(String message, Object... args) {
        logWithLevel(LogLevel.ERROR, String.format(message, args));
    }
    public void error(String message) {
        logWithLevel(LogLevel.ERROR, message);
    }


    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.minimumLogLevel = level;
        loggers.put(name, this);
    }

    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
}
