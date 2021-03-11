package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private final static HashMap<String, Logger> hashMap = new HashMap<>();
    private Level level = Level.DEBUG;
    private final String name;

    public Logger(String name) {
        this.name = name;
        hashMap.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return hashMap.get(name);
    }

    public void setLevel(String newLevel) {
        level = Level.valueOf(newLevel);
    }

    public String getLevel() {
        return level.toString();
    }

    private void log(Level level, String message) {
        if (!(level.ordinal() >= this.level.ordinal())) return;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.printf("[%s] %s %s - %s%n", level, dateFormat.format(new Date()), name, message);
    }

    private void log(Level level, String formattedMessage, Object... args) {
        log(level, String.format(formattedMessage, args));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void debug(String formattedMessage, Object... args) {
        log(Level.DEBUG, formattedMessage, args);
    }

    public void info(String formattedMessage, Object... args) {
        log(Level.INFO, formattedMessage, args);
    }

    public void warning(String formattedMessage, Object... args) {
        log(Level.WARNING, formattedMessage, args);
    }

    public void error(String formattedMessage, Object... args) {
        log(Level.ERROR, formattedMessage, args);
    }

}