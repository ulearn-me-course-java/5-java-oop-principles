package com.example.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class Logger {
    private final String name;
    private final static Hashtable<String, Logger> hashMap = new Hashtable<>();
    private final ArrayList<MessageHandler> handlers;
    private levelOfImportance level = levelOfImportance.DEBUG;
    private enum levelOfImportance {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    Logger(String name) {
        this.name = name;
        hashMap.put(name, this);
        handlers = new ArrayList<>();
    }

    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return hashMap.containsKey(name) ? hashMap.get(name) : new Logger(name);
    }

    public void debug(String message) {
        log(levelOfImportance.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(levelOfImportance.DEBUG, message, args);
    }

    public void info(String message) {
        log(levelOfImportance.INFO, message);
    }

    public void info(String message, Object... args) {
        log(levelOfImportance.INFO, message, args);
    }

    public void warning(String message) {
        log(levelOfImportance.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(levelOfImportance.WARNING, message, args);
    }

    public void error(String message) {
        log(levelOfImportance.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(levelOfImportance.ERROR, message, args);
    }

    public void log(levelOfImportance level, String message) {
        Date date = new Date();
        System.out.printf("[%d] %d %d - %d", level, date.toString(), name, message);
    }

    private void log(levelOfImportance level, String message, Object... arg) {
        log(level, String.format(message, arg));
    }

    public void setLevel(String lvl) {
        level = levelOfImportance.valueOf(lvl);
    }

    public String getLevel() {
        return String.valueOf(level);
    }
}
