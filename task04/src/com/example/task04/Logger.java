package com.example.task04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    public enum Levels {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private enum MessageHandlers {
        ConsoleHandler,
        FileHandler,
        RotationFileHandler,
        MemoryHandler
    }

    private String name;
    private Levels level = Levels.DEBUG;
    private MessageHandler[] messageHandlers = new MessageHandler[4];
    private static ArrayList<Logger> loggers = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        loggers.add(this);
    }

    public Logger(String name, Levels level) {
        this.name = name;
        this.level = level;
        loggers.add(this);
    }

    public Logger(String name, MessageHandler[] messageHandlers) {
        this.name = name;
        for (MessageHandler messageHandler : messageHandlers) {
            addMessageHandler(messageHandler);
        }
        loggers.add(this);
    }

    public Logger(String name, Levels level, MessageHandler[] messageHandlers) {
        this.name = name;
        this.level = level;
        for (MessageHandler messageHandler : messageHandlers) {
            addMessageHandler(messageHandler);
        }
        loggers.add(this);
    }

    public void addMessageHandler(MessageHandler messageHandler) {
        String handlerName = messageHandler.getClass().getSimpleName();
        MessageHandlers handlerEnum = MessageHandlers.valueOf(handlerName);
        if (messageHandlers[handlerEnum.ordinal()] != null) return;
        messageHandlers[handlerEnum.ordinal()] = messageHandler;
    }

    public static Logger getLogger(String name) {
        for (Logger logger: loggers) {
            if (logger.name.equals(name))
                return logger;
        }
        return new Logger(name);
    }

    public String getName() {
        return name;
    }

    public Levels getLevel() {
        return level;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public void debug(String message) {
        log(Levels.DEBUG, message);
    }

    public void debug(String messageFormat, Object... params) {
        log(Levels.DEBUG, messageFormat, params);
    }

    public void info(String message) {
        log(Levels.INFO, message);
    }

    public void info(String messageFormat, Object... params) {
        log(Levels.INFO, messageFormat, params);
    }

    public void warning(String message) {
        log(Levels.WARNING, message);
    }

    public void warning(String messageFormat, Object... params) {
        log(Levels.WARNING, messageFormat, params);
    }

    public void error(String message) {
        log(Levels.ERROR, message);
    }

    public void error(String messageFormat, Object... params) {
        log(Levels.ERROR, messageFormat, params);
    }

    private void log(Levels level, String message) {
        if (this.level.ordinal() > level.ordinal()) return;
        String formattedMessage = String.format("[%s] %s %s - %s", level.name(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")), name, message);
        messageHandlersLog(formattedMessage);
    }

    private void log(Levels level, String messageFormat, Object... params) {
        if (this.level.ordinal() > level.ordinal()) return;
        String formattedMessage = String.format(messageFormat, params);
        messageHandlersLog(formattedMessage);
    }

    private void messageHandlersLog(String message) {
        for (MessageHandler handler: messageHandlers) {
            if (handler == null) continue;
            handler.log(message);
        }
    }
}