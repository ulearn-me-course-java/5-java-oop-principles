package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

enum LEVEL {
    DEBUG, INFO, WARNING, ERROR
}
public class Logger {
    private final String name;
    private LEVEL level;
    private final static HashMap<String, Logger> loggers = new HashMap<>();

    public Logger(String name){
        this.name = name;
    }
    public Logger(String name, LEVEL lvl){
        this.name = name;
        level = lvl;
    }
    public void setLevel(LEVEL lvl){
        level = lvl;
    }
    public String getName(){
        return name;
    }
    public LEVEL getLevel(){
        return level;
    }
    public static Logger getLogger(String name){
        if(!loggers.containsKey(name)){
            loggers.put(name, new Logger(name));
        }
            return loggers.get(name);
    }

    private void log(LEVEL lvl, String message){
        log(lvl, message, new Object[0]);
    }
    private void log(LEVEL lvl, String message, Object... args){
        if(lvl.ordinal() >= level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
    }
    public void debug(String message){
        log(LEVEL.DEBUG, message);
    }
    public void debug(String message, Object... args){
        log(LEVEL.DEBUG, message, args);
    }
    public void info(String message){
        log(LEVEL.INFO, message);
    }
    public void info(String message, Object... args){
        log(LEVEL.INFO, message, args);
    }
    public void warning(String message){
        log(LEVEL.WARNING, message);
    }
    public void warning(String message, Object... args){
        log(LEVEL.WARNING, message, args);
    }
    public void error(String message){
        log(LEVEL.ERROR, message);
    }
    public void error(String message, Object... args){
        log(LEVEL.ERROR, message, args);
    }
}
