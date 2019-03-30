package com.example.task01;

import sun.rmi.runtime.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

enum LogLevel {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    public static Map<String, Logger> loggersMap = new HashMap<>();
    private LogLevel level;
    private final String name;

    public Logger(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        if (loggersMap.containsKey(name)) {
            return loggersMap.get(name);
        }
        Logger temp = new Logger(name);
        loggersMap.put(name, temp);
        return temp;
    }

    public void log(LogLevel level, String message){
        if(this.level == null || level.compareTo(this.level) <= 0){
            DateFormat dateFormat = new SimpleDateFormat("YYYY.MM.DD hh:mm:ss");
            Date date = new Date();
            System.out.println(String.format("[%s] %s %s - %s", level, dateFormat.format(date), name, message));
        }
    }

    public void log(LogLevel level, String format, Object... args){
        log(level, String.format(format, args));
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogLevel getLevel(){
        return this.level;
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }
    public void debug(String format, Object... args){
        log(LogLevel.DEBUG, format, args);
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }
    public void info(String format, Object... args){
        log(LogLevel.INFO, format, args);
    }

    public void warning(String message){
        log(LogLevel.WARNING, message);
    }
    public void warning(String format, Object... args){
        log(LogLevel.WARNING, format, args);
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }
    public void error(String format, Object... args){
        log(LogLevel.ERROR, format, args);
    }
}
