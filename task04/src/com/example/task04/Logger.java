package com.example.task04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Logger {
    public enum Level {
        DEBUG, INFO, WARNING, ERROR
    }

    private final ArrayList<MessageHandler> messageHandlers;
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private Level level;

    public Logger(String name, Level level, MessageHandler... handlers) {
        this.level = level;
        this.name = name;
        this.messageHandlers = new ArrayList<>();
        this.messageHandlers.addAll(Arrays.asList(handlers));
        if (!loggers.containsKey(name)) {
            loggers.put(name, this);
        }
    }

    public Logger(String name, MessageHandler... handlers) {
        this.level = Level.DEBUG;
        this.name = name;
        this.messageHandlers = new ArrayList<>();
        this.messageHandlers.addAll(Arrays.asList(handlers));
        if (!loggers.containsKey(name)) {
            loggers.put(name, this);
        }
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        if (logger == null) {
            return new Logger(name, new ConsoleHandler());
        }
        return logger;
    }

    public String getName() {
        return name;
    }

    public void log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            String formattedMessage = String.format("[%s] %s %s - %s",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message);
            for (MessageHandler messageHandler : messageHandlers) {
                messageHandler.log(formattedMessage);
            }
        }
    }

    public void log(Level level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            String formattedMessage = String.format(template, args);
            for (MessageHandler messageHandler : messageHandlers) {
                messageHandler.log(formattedMessage);
            }
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

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void addMessageHandler(MessageHandler... messageHandlers) {
        this.messageHandlers.addAll(Arrays.asList(messageHandlers));
    }
}
