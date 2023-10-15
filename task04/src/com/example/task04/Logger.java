package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private String name;
    private ImportanceLevel iLevel;
    private static final Map<String, Logger> loggers = new HashMap<>();

    public String getName() {
        return name;
    }

    public ImportanceLevel getLevel() {
        return iLevel;
    }

    public void setLevel(ImportanceLevel iLevel) {
        this.iLevel = iLevel;
    }

    public Logger(String name, ImportanceLevel iLevel){
        this.name = name;
        this.iLevel = iLevel;
        loggers.put(name, this);
    }

    public Logger(String name) {
        this(name, ImportanceLevel.DEBUG);
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        return logger == null ? new Logger(name) : logger;
    }

    private void log(ImportanceLevel iLevel, String message) {
        if (iLevel.ordinal() >= this.iLevel.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    iLevel,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message
                    ));
        }
    }

    private void log(ImportanceLevel iLevel, String template, Object... args) {
        if (iLevel.ordinal() >= this.iLevel.ordinal()) {
            System.out.println(MessageFormat.format(template, args));
        }
    }

    public void debug(String message) {
        log(ImportanceLevel.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(ImportanceLevel.DEBUG, message, args);
    }

    public void info(String message) {
        log(ImportanceLevel.INFO, message);
    }

    public void info(String message, Object... args) {
        log(ImportanceLevel.INFO, message, args);
    }

    public void warning(String message) {
        log(ImportanceLevel.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(ImportanceLevel.WARNING, message, args);
    }

    public void error(String message) {
        log(ImportanceLevel.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(ImportanceLevel.ERROR, message, args);
    }
}
