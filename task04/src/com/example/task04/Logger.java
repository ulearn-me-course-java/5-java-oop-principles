package com.example.task04;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;

enum LevelsOfImportance {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<String, Logger>();
    private Vector<MessageHandler> handlers = new Vector<MessageHandler>();
    private final String loggerName;
    private LevelsOfImportance loggerLevel;

    public Logger (String loggerName) {
        if (loggers.containsKey(loggerName))
            throw new IllegalArgumentException("Экземпляр с таким именем уже суещствует");

        this.loggerName = loggerName;
        loggers.put(loggerName, this);
    }

    public static Logger getLogger(String loggerName) {
        if (loggers.containsKey(loggerName))
            return loggers.get(loggerName);
        return new Logger(loggerName);
    }

    public String getName() {
        return this.loggerName;
    }

    public void setLevel(LevelsOfImportance level) {
        this.loggerLevel = level;
    }

    public LevelsOfImportance getLevel() {
        return loggerLevel;
    }

    public void addMessageHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    public void removeMessageHandler(MessageHandler handler) {
        handlers.remove(handler);
    }

    public void log(LevelsOfImportance level, String message, Object... args) {
        String messageFormated = "[" + level + "] " +
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").withZone(ZoneId.systemDefault()).format(Instant.now()) + " " +
                getName() + " - " +
                String.format(message, args);
        for (MessageHandler messageHandler: handlers) {
            messageHandler.printMessage(messageFormated);
        }
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
