package com.example.task01;

import java.util.*;
import java.text.*;

public class Logger {
    private final String name;
    private Level level = Level.DEBUG;
    private static HashMap<String, Logger> loggers = new HashMap<>();

    public static enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private Logger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void error(String msg) {
        log(Level.ERROR, msg);
    }

    public void error(String format, Object... varargs) {
        log(Level.ERROR, String.format(format, varargs));
    }

    public void warning(String msg) {
        log(Level.WARNING, msg);
    }

    public void warning(String format, Object... varargs) {
        log(Level.WARNING, String.format(format, varargs));
    }

    public void info(String msg) {
        log(Level.INFO, msg);
    }

    public void info(String format, Object... varargs) {
        log(Level.INFO, String.format(format, varargs));
    }

    public void debug(String msg) {
        log(Level.DEBUG, msg);
    }

    public void debug(String format, Object... varargs) {
        log(Level.DEBUG, String.format(format, varargs));
    }

    public void log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            String dateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
            System.out.println(String.format("[%s] %s %s - %s", level, dateNow, name, message));
        }
    }

    public void log(Level level, String format, Object... varargs) {
        log(level, String.format(format, varargs));
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        } else {
            Logger logger = new Logger(name);
            loggers.put(logger.name, logger);
            return logger;
        }
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}