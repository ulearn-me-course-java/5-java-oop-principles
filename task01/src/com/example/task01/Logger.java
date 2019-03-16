package com.example.task01;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private static Map<String, Logger> nameLoggers = new HashMap<>();
    private static int countLoggers = 1;
    private final String name;
    private LevelsOfImportance level;
    private String message;
    private String messageLogger;

    public Logger() {
        name = "Logger #" + countLoggers++;
        nameLoggers.put(getName(), this);
    }

    public Logger(String name) {
        this.name = name;
        nameLoggers.put(getName(), this);
    }

    public static Logger getLogger(String name) {
        if (!nameLoggers.containsKey(name)) return new Logger(name);
        return nameLoggers.get(name);
    }

    public String getMessageLogger() {
        return messageLogger;
    }

    public void log(LevelsOfImportance level, String message, Object... args) {
        this.message = String.format(message, args);
        setLevel(level);
        messageLogger = "[" + level + "] " +
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").withZone(ZoneId.systemDefault()).format(Instant.now()) +
                " " + getName() + " - " + message;
        System.out.println(messageLogger);
    }

    public void log(LevelsOfImportance level, String message) {
        log(level, message, (Object) null);
    }

    public void error(String message) {
        log(LevelsOfImportance.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(LevelsOfImportance.ERROR, message, args);
    }

    public void info(String message) {
        log(LevelsOfImportance.INFO, message);
    }

    public void info(String message, Object... args) {
        log(LevelsOfImportance.INFO, message, args);
    }

    public void warning(String message) {
        log(LevelsOfImportance.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(LevelsOfImportance.WARNING, message, args);
    }

    public void debug(String message) {
        log(LevelsOfImportance.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(LevelsOfImportance.DEBUG, message, args);
    }

    public String getName() {
        return name;
    }

    public LevelsOfImportance getLevel() {
        return level;
    }

    public void setLevel(LevelsOfImportance level) {
        this.level = level;
    }
}