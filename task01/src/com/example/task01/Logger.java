package com.example.task01;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;

public class Logger {
    private Level currentLevel;
    private String name;

    private static Map<String,Logger> loggers = new HashMap<String,Logger>();

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        if(loggers.containsKey(name)){
            return loggers.get(name);
        }
        else
            throw new NullPointerException();
    }

    public Logger(String name){
        if(!loggers.containsKey(name)){
            this.name = name;
            loggers.put(name, this);
        }
    }

    private void log(Level level, String message){
        log(level, message, null);
    }

    private void log(Level level, String fMessage, Object... args){
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        if(currentLevel.ordinal()<=level.ordinal()){
            System.out.println("[" + level + "] " + date.format(new Date()) + " " + this.name + " - " + String.format(fMessage, args));
        }
    }
    public void debug(String message){
        log(Level.DEBUG, message, null);
    }

    public void debug(String fMessage, Object... args){
        log(Level.DEBUG, fMessage, args);
    }

    public void info(String message){
        log(Level.INFO, message, null);
    }

    public void info(String fMessage, Object... args){
        log(Level.INFO, fMessage, args);
    }

    public void warning(String message){
        log(Level.WARNING, message, null);
    }

    public void warning(String fMessage, Object... args){
        log(Level.WARNING, fMessage, args);
    }

    public void error(String message){
        log(Level.ERROR, message, null);
    }

    public void error(String fMessage, Object... args){
        log(Level.ERROR, fMessage, args);
    }

    public void setLevel(Level level){
        currentLevel = level;
    }

    public Level getLevel(){
        return currentLevel;
    }
}
