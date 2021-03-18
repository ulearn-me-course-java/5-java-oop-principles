package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

public class Logger implements MessageHandler {

    private static final Dictionary<String, MessageHandler> loggers = new Hashtable<>();
    private final String name;
    private Level level;

    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static MessageHandler getLogger(String name) {
        if (loggers.get(name) != null) {
            return loggers.get(name);
        } else {
            return new ConsoleHandler(name);
        }
    }

    public void setLevel(Level desiredLevel) {
        level = desiredLevel;
    }

    public Level getLevel() {
        return level;
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(Level.DEBUG, template, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String template, Object... args) {
        log(Level.INFO, template, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(Level.WARNING, template, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(Level.ERROR, template, args);
    }

    @Override
    public void log(Level logLevel, String message) {
        Date now = new Date();
        SimpleDateFormat nowFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.println("[" + logLevel + "] " + nowFormat.format(now) + " " + name + " - " + message);
    }

    @Override
    public void log(Level logLevel, String template, Object... args) {
        log(logLevel, String.format(template, args));
    }
}
