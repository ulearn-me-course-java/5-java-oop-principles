package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    private final String name;
    private final static HashMap<String, Logger> loggers = new HashMap<>();
    private ImportanceLevel level;
    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        if (loggers.get(name) == null)
            loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public ImportanceLevel getLevel(){
        return level;
    }

    public void setLevel(ImportanceLevel level){
        this.level = level;
    }

    public void debug(String message){
        log(ImportanceLevel.DEBUG, message);
    }

    public void debug(String format, Object ...args){
        log(ImportanceLevel.DEBUG, format, args);
    }

    public void info(String message){
        log(ImportanceLevel.INFO, message);
    }

    public void info(String format, Object ...args){
        log(ImportanceLevel.INFO, format, args);
    }

    public void warning(String message){
        log(ImportanceLevel.WARNING, message);
    }

    public void warning(String format, Object ...args){
        log(ImportanceLevel.WARNING, format, args);
    }

    public void error(String message){
        log(ImportanceLevel.ERROR, message);
    }

    public void error(String format, Object ...args){
        log(ImportanceLevel.ERROR, format, args);
    }

    public void log(ImportanceLevel logLevel, String message){
        if (logLevel.ordinal() >= this.level.ordinal()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + logLevel + "] " + formatter.format(date) + " " + this.name + " - " + message);
        }
    }

    public void log(ImportanceLevel logLevel, String format, Object ...args){
        if (logLevel.ordinal() >= this.level.ordinal()) {
            System.out.println(String.format(format, args));
        }
    }

}
