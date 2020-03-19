package com.example.task01;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private String name;
    private Level level;
    private static Logger[] loggers = new Logger[0];
    private static int count;

    public Logger() {
        if (count == loggers.length) {
            int newLength = (loggers.length + 1) * 2;
            loggers = Arrays.copyOf(loggers, newLength);
        }
        loggers[count++] = this;
    }

    public Logger(String name) {
        this();
        this.name = name;
    }

    public static Logger getLogger(String name) {
        for (Logger logger : loggers) {
            if (logger.name.equals(name)) return logger;
        }
        return new Logger(name);
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return currentDate.format(dateFormatter);
    }

    public String getTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return currentTime.format(dateFormatter);
    }

    public void log(Level level, String message) {
        log(level, message, null);
    }

    public void log(Level level, String message, Object... args) {
        String formattedMessage =
                String.format("[%s] %s %s %s - %s", level, getDate(), getTime(), name, message);
        System.out.println(formattedMessage);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(Level.DEBUG, message, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(Level.WARNING, message, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(Level.ERROR, message, args);
    }
}
