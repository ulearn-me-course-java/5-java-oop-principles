package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {
    private String name;
    private Level level;
    public static Map<String, Logger> loggerMap = new Hashtable<>();
    public Logger(String name){
        loggerMap.put(name, this);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static Logger getLogger(String name){
        Logger logger = loggerMap.get(name);
        if (logger == null){
            return new Logger(name);
        }
        return logger;
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public Level getLevel(){
        return level;
    }
    private String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("YYYY.MM.DD hh:mm:ss");
        return formatter.format(date);
    }
    public String error(String message){
        return log(Level.ERROR, message);
    }

    public String error(String format, Object...args){
        return log(Level.ERROR, format, args);
    }
    public String info(String message){
        return log(Level.INFO, message);
    }
    public String info(String format, Object...args){
        return log(Level.INFO, format, args);
    }
    public String debug(String message){
        return log(Level.DEBUG, message);
    }
    public String debug(String format, Object...args){
        return log(Level.DEBUG, format, args);
    }
    public String warning(String message){
        return log(Level.WARNING, message);
    }
    public String warning(String format, Object...args){
        return log(Level.WARNING, format, args);
    }
    public String log(Level level, String message){
        if (this.level.currency >= level.currency){
            return "[" + level.toString() + "] " + getCurrentDate() + " " + name + " - " + message;
        }
        return "";
    }
    public String log(Level level, String format, Object...args){
        if (this.level.currency >= level.currency){
            String message = String.format(format, args);
            return "[" + level.toString() + "] " + getCurrentDate() + " " + name + " - " + message;
        }
        return "";
    }
}
enum Level{
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),;
    int currency;
    Level(int currency) {
        this.currency = currency;
    }
    Level(){}
}
