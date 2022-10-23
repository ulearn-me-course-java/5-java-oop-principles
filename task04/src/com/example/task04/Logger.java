package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String name;
    private ImportanceLevel lvl;
    private static Map<String, Logger> loggers = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        this.lvl = ImportanceLevel.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, ImportanceLevel lvl) {
        this.name = name;
        this.lvl = lvl;
        loggers.put(name, this);
    }

    public String getName() {
        return name;
    }

    public ImportanceLevel getLevel() {

        return lvl;
    }

    public void setLevel(ImportanceLevel lvl) {
        this.lvl = lvl;
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        }
        return new Logger(name);
    }

    public void info(String message) {
        log(ImportanceLevel.INFO, message);
    }

    public void info(String message, Object... params) {
        log(ImportanceLevel.INFO, message, params);
    }

    public void debug(String message) {
        log(ImportanceLevel.DEBUG, message);
    }

    public void debug(String message, Object... params) {
        log(ImportanceLevel.DEBUG, message, params);
    }

    public void warning(String message) {
        log(ImportanceLevel.WARNING, message);
    }

    public void warning(String message, Object... params) {
        log(ImportanceLevel.WARNING, message, params);
    }

    public void error(String message) {
        log(ImportanceLevel.ERROR, message);
    }

    public void error(String message, Object... params) {
        log(ImportanceLevel.ERROR, message, params);
    }

    public void log(ImportanceLevel lvl, String name) {
        logMessage(lvl, name);
    }

    public void log(ImportanceLevel lvl, String name, Object... params) {
        logMessage(lvl, name, params);
    }



    private void logMessage(ImportanceLevel lvl, String message) {
        if (lvl.ordinal() >= this.lvl.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    lvl,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }

    private void logMessage(ImportanceLevel lvl, String message, Object... params) {
        if (lvl.ordinal() >= this.lvl.ordinal()) {
            System.out.println(MessageFormat.format(message, params));
        }
    }
}
