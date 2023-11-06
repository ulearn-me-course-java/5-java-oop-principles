package com.example.task01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class Logger {

    private static HashMap<String, Logger> loggers = new HashMap<String, Logger>();
    private final String name;

    public String getName(){
        return this.name;
    }
    private Level level = Level.DEBUG;

    public Level getLevel(){
        return this.level;
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public static Logger getLogger(String name){
        if(loggers.containsKey(name)){
            return loggers.get(name);
        }
        return new Logger(name);
    }

    public void debug(String message){
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... params){
        log(Level.DEBUG, message, params);
    }

    public void info(String message){
        log(Level.INFO, message);
    }

    public void info(String message, Object... params){
        log(Level.INFO, message, params);
    }

    public void warning(String message){
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... params){
        log(Level.WARNING, message, params);
    }

    public void error(String message){
        log(Level.ERROR, message);
    }

    public void error(String message, Object... params){
        log(Level.ERROR, message, params);
    }

    public void log(Level level, String message){
        if(level.ordinal() >= this.level.ordinal()){
            String str = String.format(
                    "[%s] %s %s - %s",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    getName(),
                    message
            );
            System.out.printf(str);
        }
    }
    public void log(Level level, String message, Object... params){
        log(level, String.format(message,params));
    }

    public Logger(String name){
        this.name = name;
        loggers.put(this.name, this);
    }
}
