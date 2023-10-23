package com.example.task04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Logger {
    private final String name;
    public final MessageHandler[] messageHandlers;
    static private ArrayList<Logger> loggers = new ArrayList<>();
    public enum Levels {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    private Levels level = Levels.DEBUG;
    public Logger(String name, Object... handlers ) {
        this.name = name;
        loggers.add(this);
        messageHandlers = new MessageHandler[4];
        for (Object handler : handlers) {
            AddHandler((MessageHandler) handler);
        }
    }
    private void AddHandler(MessageHandler messageHandler){
        if (messageHandler instanceof ConsoleHandler){
            messageHandlers[0] = messageHandler;
        }else if (messageHandler instanceof FileHandler){
            messageHandlers[1] = messageHandler;
        }else if (messageHandler instanceof RotationFileHandler){
            messageHandlers[2] = messageHandler;
        }else if (messageHandler instanceof MemoryHandler){
            messageHandlers[3] = messageHandler;
        }
    }
    static public Logger getLogger (String name) {
        for (Logger logger: loggers) {
            if (Objects.equals(logger.getName(), name)) {
                return logger;
            }
        }
        return new Logger(name);
    }

    public String getName (){
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
        String newMessage = String.format("[%s] %s %s - %s", level.name(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")), name, message);
        handlerInvoke(newMessage);
    }
    private void log(Levels level, String messageFormat, Object... params) {
        if (this.level.ordinal() > level.ordinal()) return;
        String message = String.format(messageFormat, params);
        handlerInvoke(message);
    }

    private void handlerInvoke(String message) {
        for (MessageHandler handler: messageHandlers) {
            if (handler != null)
                handler.writeMessage(message);
        }
    }
}
