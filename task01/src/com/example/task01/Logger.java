package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger
{
    enum Level{
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private final String name;
    private Level level;
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");

    public Logger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name)
    {
        return loggers.containsKey("name") ? loggers.get(name) : new Logger(name);
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

    public void debug(String message, Object... args) {
        log(Level.DEBUG, message, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(Level.WARNING, message, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(Level.ERROR, message, args);
    }

    public void log(Level level, String message, Object... args) {
        log(level, String.format(message, args));
    }

    public void log(Level level, String message){
        if(level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, sdf.format(new Date()), name, message));
    }
}
