package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    enum Level{
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private String name;
    private Level level;
    private MessageHandler handler;
    private static HashMap<String, Logger> loggers = new HashMap<>();

    public Logger(String name, MessageHandler handler) {
        this.name = name;
        this.handler = handler;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return loggers.containsKey("name") ? loggers.get(name) : new Logger(name, new ConsoleHandler());
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

    public void log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()){
            Date dateNow = new Date();
            String date = new SimpleDateFormat("yyyy.mm.dd").format(dateNow);
            String time = new SimpleDateFormat("hh:mm:ss").format(dateNow);
            handler.log(String.format("[%d] %d %d  %d - %d", level, date, time, name, message));
        }
    }
}