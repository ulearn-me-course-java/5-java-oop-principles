package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

enum ErrorLevel{
    DEBUG,
    INFO,
    WARNING,
    ERROR

}

public class Logger {
    private ErrorLevel level;
    private String name;

    private static HashMap<String, Logger> logs = new HashMap<>();

    public Logger(String name){
        this.name = name;
    }

    public Logger(String name, ErrorLevel level){
        this.name = name;
        this.level = level;
    }

    public void setLevel(ErrorLevel level){
        this.level = level;
    }

    public ErrorLevel getLevel(){
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

    private void showLogMeassage(ErrorLevel level, String message){
        if(level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
    }

    private void getLog(ErrorLevel level, String message){
        showLogMeassage(level, message);
    }

    public void debug(String message){
        getLog(ErrorLevel.DEBUG, message);
    }
    public void debug(String message, Object... params){
        debug(String.format(message, params));
    }


    public void info(String message){
        getLog(ErrorLevel.INFO, message);
    }
    public void info(String message, Object... params){
        info(String.format(message, params));
    }


    public void warning(String message){
        getLog(ErrorLevel.WARNING, message);
    }
    public void warning(String message, Object... params){
        warning(String.format(message, params));
    }


    public void error(String message){
        getLog(ErrorLevel.ERROR, message);
    }
    public void error(String message, Object... params){
        error(String.format(message, params));
    }

}
