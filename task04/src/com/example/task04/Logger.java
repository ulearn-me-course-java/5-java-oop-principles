package com.example.task04;

import com.example.task04.handlers.MessageHandler;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {
    public enum Level {
        DEBUG, INFO, WARNING, ERROR
    }

    private String name;
    private Level level = Level.DEBUG;
    private List<MessageHandler> handlers = new ArrayList<>();
    private static Map<String, Logger> instances = new ConcurrentHashMap<>();

    public Logger(String name) {
        this.name = name;

        if (Logger.instances.containsKey(name))
            throw new IllegalArgumentException("Logger with this name has not yet been created");

        Logger.instances.put(name, this);
    }

    public static Logger getLogger(String name) {
        return instances.containsKey(name) ? instances.get(name) : new Logger(name);
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

    public void handleWith(MessageHandler... handler) {
        handlers.addAll(Arrays.asList(handler));
    }

    public void removeHandler(Class<? extends MessageHandler> handler) {
        handlers.removeIf(it -> it.getClass() == handler);
    }

    public List<MessageHandler> getHandlers() {
        return handlers;
    }

    public void log(Level level, String message) {
        if (this.level.compareTo(level) > 0) return;

        String now = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
        String formatted_message = String.format("[%s] %s %s - %s", level, now, name, message);

        if (handlers.size() > 0) {
            handlers.forEach(handler -> handler.handle(formatted_message));
        } else {
            System.out.println("No one MessageHandler is registered");
        }
    }

    public void log(Level level, String format, Object... args) {
        log(level, String.format(format, args));
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
}