package com.example.task01;


import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;

import static java.text.MessageFormat.format;

public class Logger {
    private String name;
    private ImportanceLevel level = ImportanceLevel.DEBUG;
    private static HashMap<String, Logger> loggerList = new HashMap<>();

    private Logger(String name) {
        this.name = name;
        loggerList.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String newName) {

        if (loggerList.containsKey(newName)) {
            return loggerList.get(newName);
        }
        return new Logger(newName);
    }

    private void log(ImportanceLevel level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            System.out.println(String.format("[%s] %s %s - %s", level.name(),
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")), name, message));
        }

    }

    private void log(ImportanceLevel level, String messageFormat, Object... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            System.out.println(String.format(messageFormat, args));
        }
    }

    public void setLevel(ImportanceLevel level) {
        this.level = level;
    }

    public ImportanceLevel getLevel() {
        return level;
    }

    public void debug(String message) {
        log(ImportanceLevel.DEBUG, message);
    }

    public void debug(String messageFormat, Object... args) {
        log(ImportanceLevel.DEBUG, messageFormat, args);
    }

    public void info(String message) {
        log(ImportanceLevel.INFO, message);
    }

    public void info(String messageFormat, Object... args) {
        log(ImportanceLevel.INFO, messageFormat, args);
    }

    public void warning(String message) {
        log(ImportanceLevel.WARNING, message);
    }

    public void warning(String messageFormat, Object... args) {
        log(ImportanceLevel.WARNING, messageFormat, args);
    }

    public void error(String message) {
        log(ImportanceLevel.ERROR, message);
    }

    public void error(String messageFormat, Object... args) {
        log(ImportanceLevel.ERROR, messageFormat, args);
    }
}

