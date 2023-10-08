package com.example.task01;

import java.text.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    private static List<Logger> loggers = new ArrayList<>();
    final String name;
    private Level level;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public Logger(String name){
        this.name = name;
        loggers.add(this);
    }

    public String getName() { return name; }

    public static Logger getLogger(String name){
        for (Logger logger : loggers) {
            if (logger.name.equals(name)) return logger;
        }
        return null;
    }

    public void setLevel(Level level) { this.level = level; }
    public Level getLevel() { return this.level; }

    public enum Level{
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public void error(String message){
        logMessage(Level.ERROR, message);
    }

    public void error(String format, Object... args){
        logMessage(Level.ERROR, format, args);
    }

    public void warning(String message){
        logMessage(Level.WARNING, message);
    }

    public void warning(String format, Object... args){
        logMessage(Level.WARNING, format, args);
    }

    public void info(String message){
        logMessage(Level.INFO, message);
    }

    public void info(String format, Object... args){
        logMessage(Level.INFO, format, args);
    }

    public void debug(String message){
        logMessage(Level.DEBUG, message);
    }

    public void debug(String format, Object... args){
        logMessage(Level.DEBUG, format, args);
    }

    public void log(Level level, String message){
        logMessage(level, message);
    }

    public void log(Level level, String format, Object... args){
        logMessage(level, format, args);
    }

    private void logMessage(Level level, String message) {
        if(level == null){
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, dateFormat.format(new Date()), this.name, message));
        }
        else if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, dateFormat.format(new Date()), this.name, message));
        }
    }

    private void logMessage(Level level, String format, Object... args){
        if(level == null){
            System.out.println(MessageFormat.format(format, args));
        }
        else if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(format, args));
        }
    }

    public String toString() { return name; }
}
