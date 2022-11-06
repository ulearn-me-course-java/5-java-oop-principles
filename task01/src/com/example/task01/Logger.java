package com.example.task01;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}
public class Logger {
    private final String name;
    private Level level;
    private static final HashMap<String, Logger> loggers = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        this.level = Level.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
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

    public static Logger getLogger(String name) {
        if(loggers.containsKey(name))
            return loggers.get(name);
        return new Logger(name);
    }
    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String message, Object... params) {
        log(Level.INFO, message, params);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... params) {
        log(Level.DEBUG, message, params);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... params) {
        log(Level.WARNING, message, params);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String message, Object... params) {
        log(Level.ERROR, message, params);
    }

    public void log(Level level, String message) {
        logMassage(level, message);
    }

    public void log(Level level, String message, Object... params) {
        logMassage(level, message, params);
    }

    private void logMassage(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }
    private void logMassage(Level level, String message, Object... params) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(message, params));
        }
    }
}
