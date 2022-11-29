package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    final private String name;
    private ImportanceLevel importanceLevel;
    private static HashMap<String, Logger> mapOfLogger;

    public Logger(String name) {
        if (name == null)
            throw new IllegalArgumentException("Имя не может быть null");
        else {
            this.name = name;
            importanceLevel = ImportanceLevel.DEBUG;
        }
    }
    public String getName() {
        return name;
    }
    public static Logger getLogger(String name) {
        if (!mapOfLogger.containsKey(name)) {
            mapOfLogger.put(name, new Logger(name));
        }
        return mapOfLogger.get(name);
    }
    public void setLevel(ImportanceLevel importanceLevel) {
        this.importanceLevel = importanceLevel;
    }
    public ImportanceLevel getLevel() {
        return importanceLevel;
    }
    public void debug(String message, MessageHandler handler) {
        log(ImportanceLevel.DEBUG, message, handler);
    }
    public void debug(String template, MessageHandler handler, Object... params) {
        log(ImportanceLevel.DEBUG, template, handler, params);
    }
    public void info(String message, MessageHandler handler) {
        log(ImportanceLevel.INFO, message, handler);
    }
    public void info(String template, MessageHandler handler, Object... params) {
        log(ImportanceLevel.INFO, template, handler, params);
    }
    public void warning(String message, MessageHandler handler) {
        log(ImportanceLevel.WARNING, message, handler);
    }
    public void warning(String template, MessageHandler handler, Object... params) {
        log(ImportanceLevel.WARNING, template, handler, params);
    }
    public void error(String message, MessageHandler handler) {
        log(ImportanceLevel.ERROR, message, handler);
    }
    public void error(String template, MessageHandler handler, Object... params) {
        log(ImportanceLevel.ERROR, template, handler, params);
    }
    public void log(ImportanceLevel importanceLevel, String message, MessageHandler handler) {
        if (importanceLevel.ordinal() >= this.importanceLevel.ordinal()) {
            SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss ");
            handler.log("[" + importanceLevel + "] " + formatForDate.format(new Date()) + " " + name + " - " + message);
        }
    }
    public void log(ImportanceLevel importanceLevel, String template, MessageHandler handler, Object... params) {
        log(importanceLevel, String.format(template, params), handler);
    }
}
