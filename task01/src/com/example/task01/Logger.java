package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private LoggerLevel level;

    public Logger(String name){
        this.name = name;
        level = LoggerLevel.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, LoggerLevel level){
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }

    public String getName(){
        return name;
    }

    public LoggerLevel getLevel(){
        return level;
    }

    public void setLevel(LoggerLevel level){
        this.level = level;
    }

    public static Logger getLogger(String name){
        if(!loggers.containsKey(name))
            loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public void debug(String message){
        log(LoggerLevel.DEBUG, message);
    }

    public void debug(String format, Object... objects){
        log(LoggerLevel.DEBUG, format, objects);
    }

    public void info(String message){
        log(LoggerLevel.INFO, message);
    }

    public void info(String format, Object... objects){
        log(LoggerLevel.INFO, format, objects);
    }

    public void warning(String message){
        log(LoggerLevel.WARNING, message);
    }

    public void warning(String format, Object... objects){
        log(LoggerLevel.WARNING, format, objects);
    }

    public void error(String message){
        log(LoggerLevel.ERROR, message);
    }

    public void error(String format, Object... objects){
        log(LoggerLevel.ERROR, format, objects);
    }

    public void log(LoggerLevel loglevel, String message){
        if(this.level.ordinal() <= loglevel.ordinal()) {
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", loglevel, data, name, message));
        }
    }

    public void log(LoggerLevel loglevel, String format, Object... objects){
        if(this.level.ordinal() <= loglevel.ordinal()) {
            System.out.println(MessageFormat.format(format, objects));
        }
    }
}