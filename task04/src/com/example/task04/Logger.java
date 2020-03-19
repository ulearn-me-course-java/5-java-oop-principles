package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.*;



/**
 * Класс реализует логгирование сообщений с различными уровнями важности (уровнями логгирования).
 */
public class Logger {

    private final String name;
    private Level level;
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();
    private static List<MessageHandler> handlers = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name) {
        return (loggers.containsKey(name)) ? loggers.get(name) : new Logger(name);
    }

    public static void addHandler( MessageHandler handler) {
        handlers.add(handler);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public void log( String message,  Level level) {
        if (this.level.compareTo(level) >= 0) {
            String loggedMessage = "[" + level + "] " + dateFormat.format(new Date()) + " " + name + " - " + message;
            for (MessageHandler handle : this.handlers) {
                handle.printMessage(loggedMessage);
            }
        }
    }

    public void log( String template,  Level level,  Object... objects) {
        if (this.level.compareTo(level) >= 0) {
            String message = String.format(template, objects);
            this.log(message, level);
        }
    }

    public void debug( String message) {
        log(message, Level.DEBUG);
    }

    public void debug( String template,  Object... objects) {
        log(template, Level.DEBUG, objects);
    }

    public void info( String message) {
        log(message, Level.INFO);
    }

    public void info( String template,  Object... objects) {
        log(template, Level.INFO, objects);
    }

    public void warning( String message) {
        log(message, Level.WARNING);
    }

    public void warning( String template,  Object... objects) {
        log(template, Level.WARNING, objects);
    }

    public void error( String message) {
        log(message, Level.ERROR);
    }

    public void error( String template,  Object... objects) {
        log(template, Level.ERROR, objects);
    }
}

