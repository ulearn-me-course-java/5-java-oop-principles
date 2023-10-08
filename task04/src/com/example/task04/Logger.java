package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Logger {
    private String name;
    private LogLevel level;
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private static ArrayList<MessageHandler> handlers = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        this.level = LogLevel.INFO;
        handlers.add(new ConsoleHandler());
        loggers.put(this.name, this);
    }

    public Logger(String name, ArrayList<MessageHandler> messageHandlers) {
        this.name = name;
        this.level = LogLevel.INFO;
        handlers = messageHandlers;
        loggers.put(this.name, this);
    }

    public Logger(String name, LogLevel level, ArrayList<MessageHandler> messageHandlers) {
        this.name = name;
        this.level = level;
        handlers = messageHandlers;
        loggers.put(this.name, this);
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        if (loggers.get(name) == null)
            loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String format, Object... objects) {
        log(LogLevel.INFO, format, objects);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String format, Object... objects) {
        log(LogLevel.DEBUG, format, objects);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String message, Object... objects) {
        log(LogLevel.WARNING, message);
    }


    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String format, Object... objects) {
        log(LogLevel.ERROR, format, objects);
    }

    private void log(LogLevel level, String message) {
        if(this.level.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printedMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, name, message);

            for(MessageHandler messageHandler : handlers)
                messageHandler.log(printedMessage);

        }
    }
    private void log(LogLevel level, String format, Object... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            String message = MessageFormat.format(format, args);

            for (MessageHandler messageHandler : handlers)
                messageHandler.log(message);
        }
    }
}
