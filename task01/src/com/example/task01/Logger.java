package com.example.task01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {
    private static ArrayList<Logger> loggers = new ArrayList<>();
    private String name;
    private Level level = Level.DEBUG;

    public Logger(){
        Logger.loggers.add(this);
    }

    public Logger(String name){
        this.name = name;
        Logger.loggers.add(this);
    }

    public String getName(){
        return name;
    }

    public void setName(String _name){
        name = _name;
    }

    public Level getLevel(){
        return level;
    }

    public void setLevel(Level _level){
        level = _level;
    }

    public static Logger getLogger(String _name){
        for(Logger logger : loggers){
            if(logger.getName().equals(_name)){
                return logger;
            }
        }

        return new Logger(_name);
    }

    public void log(Level level, String message){
        if(level.ordinal() < this.level.ordinal())
            return;

        System.out.printf(
                "[%s] %s %s - %s%n", level, getDateTime(), getName(), message
        );
    }

    public void log(Level level, String message, Object... args){
        if(level.ordinal() < this.level.ordinal())
            return;

        String someStr = String.format("[%s] %s %s - ", level, getDateTime(), getName());
        System.out.printf(someStr + (message) + "%n", args);
    }

    public String getDateTime(){
        Date date =  new Date();
        String pattern = "yyyy.MM.dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);

        return df.format(date);
    }

    public void error(String message){
        log(Level.ERROR, message);
    }

    public void error(String message, Object... args){
        log(Level.ERROR, message, args);
    }

    public void warning(String message){
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... args){
        log(Level.WARNING, message, args);
    }

    public void info(String message){
        log(Level.INFO, message);
    }

    public void info(String message, Object... args){
        log(Level.INFO, message, args);
    }

    public void debug(String message){
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... args){
        log(Level.DEBUG, message, args);
    }
}
