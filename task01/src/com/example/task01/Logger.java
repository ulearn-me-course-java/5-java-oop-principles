package com.example.task01;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

enum LevelsOfImportance {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private static final HashMap<String, Logger> loggerList = new HashMap<String, Logger>();
    private final String loggerName;
    private LevelsOfImportance loggerLevel;

    public Logger (String loggerName) {
        if (loggerList.containsKey(loggerName))
            throw new IllegalArgumentException("Экземпляр с таким именем уже суещствует");

        this.loggerName = loggerName;
        loggerList.put(loggerName, this);
    }

    public static Logger getLogger(String loggerName) {
        if (loggerList.containsKey(loggerName))
            return loggerList.get(loggerName);
        return new Logger(loggerName);
    }

    public String getName() {
        return this.loggerName;
    }

    public LevelsOfImportance getLevel() {
        return loggerLevel;
    }

    public void setLevel(LevelsOfImportance level) {
        this.loggerLevel = level;
    }

    public void log(LevelsOfImportance level, String message, Object... args) {
        String messageFormated = "[" + level + "] " +
                                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").withZone(ZoneId.systemDefault()).format(Instant.now()) + " " +
                                getName() + " - " +
                                String.format(message, args);
        System.out.println(messageFormated);
    }

    public void log(LevelsOfImportance level, String message) {
        log(level, message, (Object)null);
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
}
