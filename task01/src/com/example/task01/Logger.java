package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    private String name;
    private Level level;
    private static final HashMap<String, Logger> loggers = new HashMap<>();

    public String getName() {
        return name;
    }

    public Logger(String name){
        this.name = name;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name){
        Logger logger = loggers.get(name);
        if (logger == null){
            return new Logger(name);
        }
        else {
            return logger;
        }
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String messageFormat, Object... messageArgs) {
        log(Level.DEBUG, messageFormat, messageArgs);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String messageFormat, Object... messageArgs) {
        log(Level.INFO, messageFormat, messageArgs);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String messageFormat, Object... messageArgs) {
        log(Level.WARNING, messageFormat, messageArgs);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String messageFormat, Object... messageArgs) {
        log(Level.ERROR, messageFormat, messageArgs);
    }

    public void log(Level level, String message) {
        if (this.level != null && level.compareTo(this.level) < 0) {
            return;
        }

        Date now = new Date();
        String dateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(now);
        System.out.printf("[%s] %s %s - %s%n", level, dateTime, name, message);
    }

    public void log(Level level, String messageFormat, Object... messageArgs) {
        log(level, String.format(messageFormat, messageArgs));
    }
}
