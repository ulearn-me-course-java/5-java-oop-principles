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
    public void debug(String message) {
        log(ImportanceLevel.DEBUG, message);
    }
    public void debug(String template, Object... params) {
        log(ImportanceLevel.DEBUG, template, params);
    }
    public void info(String message) {
        log(ImportanceLevel.INFO, message);
    }
    public void info(String template, Object... params) {
        log(ImportanceLevel.INFO, template, params);
    }
    public void warning(String message) {
        log(ImportanceLevel.WARNING, message);
    }
    public void warning(String template, Object... params) {
        log(ImportanceLevel.WARNING, template, params);
    }
    public void error(String message) {
        log(ImportanceLevel.ERROR, message);
    }
    public void error(String template, Object... params) {
        log(ImportanceLevel.ERROR, template, params);
    }
    public void log(ImportanceLevel importanceLevel, String message) {
        if (importanceLevel.ordinal() >= this.importanceLevel.ordinal()) {
            SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss ");
            System.out.printf("[%s] %s %s - %s%n", importanceLevel, formatForDate.format(new Date()), name, message);
        }
    }
    public void log(ImportanceLevel importanceLevel, String template, Object... params) {
        log(importanceLevel, String.format(template, params));
    }
}
