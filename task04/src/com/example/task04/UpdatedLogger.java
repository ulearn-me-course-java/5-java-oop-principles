package com.example.task04;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UpdatedLogger {
    private static final Map<String, UpdatedLogger> loggers = new HashMap<>();

    private final String name;

    private MessageHandler handler = new ConsoleHandler();
    private Important level = Important.DEBUG;

    public UpdatedLogger(String name) {
        this.name = name;
    }

    public UpdatedLogger(String name, Important imp) {
        this.name = name;
        this.level = imp;
    }

    public static UpdatedLogger getLogger(String name) {
        UpdatedLogger logger = loggers.get(name);
        if (logger == null) {
            loggers.put(name, logger = new UpdatedLogger(name));
        }
        return logger;
    }

    public String getName() {
        return name;
    }

    public Important getLevel() {
        return level;
    }

    public void setLevel(Important level) {
        this.level = level;
    }

    public void setHandler(MessageHandler handler) {
        this.handler = handler;
    }

    public void log(Important level, String message, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            handler.log(MessageFormat.format("[{0}] {1} {2} - {3}", level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").
                    format(new Date()), name, MessageFormat.format(message, args)));
        }
    }

    public void log(Important level, String message) {
        log(level, message, new Object[0]);
    }

    public void debug(String message) {
        log(Important.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(Important.DEBUG, message, args);
    }

    public void info(String message) {
        log(Important.INFO, message);
    }

    public void info(String message, Object... args) {
        log(Important.INFO, message, args);
    }

    public void warning(String message) {
        log(Important.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(Important.WARNING, message, args);
    }

    public void error(String message) {
        log(Important.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(Important.ERROR, message, args);
    }
}
