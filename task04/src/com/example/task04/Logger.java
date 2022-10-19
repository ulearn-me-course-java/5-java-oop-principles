package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Logger {
    private String name;
    private Level level;
    private List<MessageHandler> handlers = new ArrayList<>();
    private static final Map<String, Logger> loggers = new HashMap<>();

    public Logger(String name, Level level, MessageHandler... handlers) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
        this.handlers.addAll(Arrays.asList(handlers));
    }

    public Logger(String name) {
        this(name, Level.INFO, new ConsoleHandler());
    }

    public Logger(String name, Level level) {
        this(name, level, new ConsoleHandler());
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        return logger == null ? new Logger(name) : logger;
    }

    public String getName() {
        return this.name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public void log(Level level, String message) {
        logMessage(level, message);
    }

    public void log(Level level, String template, Object... args) {
        logMessage(level, template, args);
    }

    private void logMessage(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            String logMessage = MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message);
            for (MessageHandler handler : handlers) {
                handler.log(logMessage);
            }
        }
    }

    private void logMessage(Level level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            String logMessage = MessageFormat.format(template, args);
            for (MessageHandler handler : handlers) {
                handler.log(logMessage);
            }
        }
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(Level.DEBUG, template, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String template, Object... args) {
        log(Level.INFO, template, args);
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
