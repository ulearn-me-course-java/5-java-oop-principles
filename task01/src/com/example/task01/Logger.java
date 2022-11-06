package com.example.task01;

import java.io.Console;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
public class Logger {
    private final String name;
    private Level level;
    private static HashMap<String,Logger> loggers = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        this.level = Level.DEBUG;
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
    public static Logger getLogger(String name) {
        if (loggers.containsKey(name))
            return loggers.get(name);
        return new Logger(name);
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
    public void  log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }    }

    public void log(Level level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(template, args));
        }
    }
    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String template, Object... args) {
        log(Level.INFO, template, args);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(Level.DEBUG, template, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(Level.WARNING, template, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(Level.ERROR, template, args);
    }
}
