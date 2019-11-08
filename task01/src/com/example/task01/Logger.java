package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import lombok.NonNull;

enum LogLevels {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private LogLevels Level;
    private final String name;
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();

    public Logger(@NonNull String Name) {
        name = Name;
    }

    public static Logger getLogger(@NonNull String Name) {
        Logger result = new Logger(Name);
        loggers.put(result.name, result);
        return result;
    }

    public String getName() {
        return name;
    }

    public LogLevels getLevel() {
        return Level;
    }

    public void setLevel(@NonNull LogLevels level) {
        Level = level;
    }

    public void log(@NonNull LogLevels level, @NonNull String message) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println("[" + level + "] " + sdfDate.format(new Date()) + " " + name + " - " + message);
    }

    public void log(@NonNull LogLevels level, @NonNull String message, @NonNull Object... obj) {
        String msg = String.format(message, obj);
        log(level, msg);
    }

    public void debug(@NonNull String message) {
        log(LogLevels.DEBUG, message);
    }

    public void debug(@NonNull String message, @NonNull Object... obj) {
        log(LogLevels.DEBUG, message, obj);
    }

    public void info(@NonNull String message) {
        log(LogLevels.INFO, message);
    }

    public void info(@NonNull String message, @NonNull Object... obj) {
        log(LogLevels.INFO, message, obj);
    }

    public void warning(@NonNull String message) {
        log(LogLevels.WARNING, message);
    }

    public void warning(@NonNull String message, @NonNull Object... obj) {
        log(LogLevels.WARNING, message, obj);
    }

    public void error(@NonNull String message) {
        log(LogLevels.ERROR, message);
    }

    public void error(@NonNull String message, @NonNull Object... obj) {
        log(LogLevels.ERROR, message, obj);
    }
}
