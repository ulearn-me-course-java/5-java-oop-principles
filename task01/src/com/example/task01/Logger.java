package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import lombok.NonNull;

enum LogLevel {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private LogLevel level;
    private final String name;
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();

    public Logger(@NonNull String Name) {
        name = Name;
    }

    public static Logger getLogger(@NonNull String Name) {
        if (loggers.containsKey(Name)) {
            return loggers.get(Name);
        } else {
            Logger result = new Logger(Name);
            loggers.put(result.name, result);
            return result;
        }
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(@NonNull LogLevel level) {
        this.level = level;
    }

    public void log(@NonNull LogLevel level, @NonNull String message) {
        if (this.level.compareTo(level) >= 0) {
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            System.out.println("[" + level + "] " + sdfDate.format(new Date()) + " " + name + " - " + message);
        }
    }

    public void log(@NonNull LogLevel level, @NonNull String message, @NonNull Object... obj) {
        if (this.level.compareTo(level) >= 0) {
            String msg = String.format(message, obj);
            log(level, msg);
        }
    }

    public void debug(@NonNull String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(@NonNull String message, @NonNull Object... obj) {
        log(LogLevel.DEBUG, message, obj);
    }

    public void info(@NonNull String message) {
        log(LogLevel.INFO, message);
    }

    public void info(@NonNull String message, @NonNull Object... obj) {
        log(LogLevel.INFO, message, obj);
    }

    public void warning(@NonNull String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(@NonNull String message, @NonNull Object... obj) {
        log(LogLevel.WARNING, message, obj);
    }

    public void error(@NonNull String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(@NonNull String message, @NonNull Object... obj) {
        log(LogLevel.ERROR, message, obj);
    }
}
