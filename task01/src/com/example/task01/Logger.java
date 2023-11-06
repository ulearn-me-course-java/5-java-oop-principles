package com.example.task01;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String name;
    private Level level;
    private static final Map<String, Logger> loggerMap = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        this.level = Level.INFO;
        loggerMap.put(name, this);
    }

    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggerMap.put(name, this);
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        Logger logger = loggerMap.get(name);
        if (logger == null) {
            logger = new Logger(name);
        }
        return logger;
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

    public void log(Level level, String message) {
        printMessage(level, message);
    }

    public void log(Level level, String template, Object... args) {
        printMessage(level, template, args);
    }

    private void printMessage(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }

    private void printMessage(Level level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(template, args));
        }
    }
}
