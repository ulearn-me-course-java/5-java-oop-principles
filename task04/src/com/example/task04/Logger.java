package com.example.task04;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    enum Level{
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private static HashMap<String, Logger> loggers;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");

    static {
        loggers = new HashMap<>();
    }

    private final String name;
    private Level level = Level.DEBUG;
    private MessageHandler handler;

    public Logger(String name, MessageHandler handler){
        this.name = name;
        loggers.put(name, this);
        this.handler = handler;
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public Level getLevel(){
        return level;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name){
        return loggers.containsKey("name") ? loggers.get(name) : new Logger(name, new ConsoleHandler());
    }

    public void debug(String template, Object... args){
        log(Level.DEBUG, template, args);
    }

    public void info(String template, Object... args){
        log(Level.INFO, template, args);
    }

    public void warning(String template, Object... args){
        log(Level.WARNING, template, args);
    }

    public void error(String template, Object... args){
        log(Level.ERROR, template, args);
    }

    public void debug(String message){
        log(Level.DEBUG, message);
    }

    public void info(String message){
        log(Level.INFO, message);
    }

    public void warning(String message){
        log(Level.WARNING, message);
    }

    public void error(String message){
        log(Level.ERROR, message);
    }

    public void log(Level level, String template, Object... args){
        log(level, MessageFormat.format(template, args));
    }

    public void log(Level level, String message){
        if(level.ordinal() >= this.level.ordinal())
            handler.log(MessageFormat.format("[{0}] {1} {2} - {3}", level, sdf.format(new Date()), name, message));
    }
}