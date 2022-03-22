package com.example.task04;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger
{
    private LogLevel level;
    private MessageHandler handler = new ConsoleHandler();

    private final String name;

    private static final HashMap<String, Logger> LOGGERS = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        level = LogLevel.DEBUG;
    }

    public Logger(String name, LogLevel level) {
        this.level = level;
        this.name = name;
    }

    public void setHandler(MessageHandler handler) {
        this.handler = handler;
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        if (!LOGGERS.containsKey(name)) {
            LOGGERS.put(name, new Logger(name));
        }
        return LOGGERS.get(name);
    }

    private void log(LogLevel level, String message, Object... args ) {
        if(level.ordinal() >= this.level.ordinal())
            handler.log(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
    }

    private void log(LogLevel level, String message) {
        log(level, message, new Object[0]);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(LogLevel.DEBUG, message, args);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String message, Object... args) {
        log(LogLevel.INFO, message, args);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(LogLevel.WARNING, message, args);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(LogLevel.ERROR, message, args);
    }
}
