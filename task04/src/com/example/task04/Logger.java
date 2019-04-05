package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.*;

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private String name;
    private Level level;

    private static Map<String, Logger> loggers = new HashMap<>();
    public static List<MessageHandler> handlers = new ArrayList<>();

    public Logger(String name) {
        if (!loggers.containsKey(name)) {
            this.name = name;
            loggers.put(name, this);
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void log(Level level, String message) {
        log(level, message, null);
    }

    public void log(Level level, String template, Object ... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String message = String.format("[%s] %s %s - %s", level.name(), dateFormat.format(new Date()), name, String.format(template, args));

            for (MessageHandler handle : handlers) {
                handle.print(message);
            }
        }
    }

    public void debug(String message) {
        log(level.DEBUG, message, null);
    }

    public void debug(String message, Object ... args) {
        log(level.DEBUG, message, args);
    }

    public void info(String message) {
        log(level.INFO, message, null);
    }

    public void info(String message, Object ... args) {
        log(level.INFO, message, args);
    }

    public void warning(String message) {
        log(level.WARNING, message, null);
    }

    public void warning(String message, Object ... args) {
        log(level.WARNING, message, args);
    }

    public void error(String message) {
        log(level.ERROR, message, null);
    }

    public void error(String message, Object ... args) {
        log(level.ERROR, message, args);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name))
            return loggers.get(name);
        return new Logger(name);
    }


}