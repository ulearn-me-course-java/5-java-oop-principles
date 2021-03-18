package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private LogLevel level;
    private String name;

    private static HashMap<String, Logger> logs = new HashMap<>();

    public Logger(String name){
        this.name = name;
    }

    public Logger(String name, LogLevel level){
        this.name = name;
        this.level = level;
    }

    public void setLevel(LogLevel level){
        this.level = level;
    }

    public LogLevel getLevel(){
        return level;
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        if(logs.containsKey(name))
            return logs.get(name);
        return new Logger(name);

    }

    private void showLogMeassage(LogLevel level, String message){
        if(level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
    }

    private void getLog(LogLevel level, String message){
        showLogMeassage(level, message);
    }

    public void debug(String message){
        getLog(LogLevel.DEBUG, message);
    }
    public void debug(String message, Object... params){
        debug(String.format(message, params));
    }


    public void info(String message){
        getLog(LogLevel.INFO, message);
    }
    public void info(String message, Object... params){
        info(String.format(message, params));
    }


    public void warning(String message){
        getLog(LogLevel.WARNING, message);
    }
    public void warning(String message, Object... params){
        warning(String.format(message, params));
    }


    public void error(String message){
        getLog(LogLevel.ERROR, message);
    }
    public void error(String message, Object... params){
        error(String.format(message, params));
    }

}