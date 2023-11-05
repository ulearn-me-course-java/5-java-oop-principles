package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    private static final Map<String, Logger> loggers = new HashMap<>();
    private static ArrayList<MessageHandler> handlers = new ArrayList<>();

    private final String name;
    private Level level = Level.INFO;

    public Logger(String name) {
        this.name = name;
        handlers.add(new ConsoleHandler());
        loggers.put(this.name, this);
    }

    public Logger(String name, ArrayList<MessageHandler> messageHandlers) {
        this.name = name;
        handlers = messageHandlers;
        loggers.put(this.name, this);
    }

    public Logger(String name, Level level, ArrayList<MessageHandler> messageHandlers) {
        this.name = name;
        this.level = level;
        handlers = messageHandlers;
        loggers.put(this.name, this);
    }

    public static Logger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            loggers.put(name, new Logger(name));
        }
        return loggers.get(name);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    public Level getLevel() {
        return level;
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }
    public void debug(String format, Object... args) {
        log(Level.DEBUG, format, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }
    public void info(String format, Object... args) {
        log(Level.INFO, format, args);
    }
    public void warning(String message) {
        log(Level.WARNING, message);
    }
    public void warning(String format, Object... args) {
        log(Level.WARNING, format, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }
    public void error(String format, Object... args) {
        log(Level.ERROR, format, args);
    }

    private void log(Level level, String message) {
        if(this.level.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printedMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, name, message);

            for(MessageHandler messageHandler : handlers)
                messageHandler.log(printedMessage);

        }
    }
    private void log(Level level, String format, Object... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            String message = MessageFormat.format(format, args);

            for (MessageHandler messageHandler : handlers)
                messageHandler.log(message);
        }
    }
}