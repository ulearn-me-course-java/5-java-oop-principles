package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;


public class Logger {
    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private static HashMap<String, Logger> loggers = new HashMap<>();

    private final String name;
    private Level level;
    private LinkedList<MessageHandler> messageHandlers = new LinkedList<>();

    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        if (logger == null)
            return new Logger(name);
        else
            return loggers.get(name);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void clearMessageHandlers(){
        messageHandlers.clear();
    }

    public void addMessageHandlers(MessageHandler... handlers){
        messageHandlers.addAll(Arrays.asList(handlers));
    }

    public Level getLevel() {
        return level;
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String messageFormat, Object... messageArgs) {
        log(Level.DEBUG, messageFormat, messageArgs);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String messageFormat, Object... messageArgs) {
        log(Level.INFO, messageFormat, messageArgs);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String messageFormat, Object... messageArgs) {
        log(Level.WARNING, messageFormat, messageArgs);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String messageFormat, Object... messageArgs) {
        log(Level.ERROR, messageFormat, messageArgs);
    }

    public void log(Level level, String message) {
        if (this.level != null && level.compareTo(this.level) < 0)
            return;
        Date now = new Date();
        String dateTime = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss").format(now);
        String logMessage = String.format("[%s] %s %s - %s", level, dateTime, name, message);
        for (MessageHandler handler: messageHandlers){
            handler.log(logMessage);
        }
    }

    public void log(Level level, String messageFormat, Object... messageArgs) {
        log(level, String.format(messageFormat, messageArgs));
    }
}