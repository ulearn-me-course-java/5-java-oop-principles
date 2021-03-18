package com.example.task01;
import java.text.SimpleDateFormat;
import java.util.*;

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {

    private Level level;
    private final String name;
    private static final HashMap<String, Logger> logs = new HashMap<>();

    public Logger(String name){
        this.name = name;
    }

    public Logger(String name, Level level){
        this.name = name;
        this.level = level;
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public Level getLevel(){
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

    public void Meassage(Level level, String message){
        System.out.printf("[%s] %s %s - %s%n",
                level,
                new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                name,
                message);
    }

    private void getLog(Level level, String message){
        Meassage(level, message);
    }

    public void debug(String message){
        getLog(Level.DEBUG, message);
    }
    public void debug(String message, Object... params){
        debug(String.format(message, params));
    }


    public void info(String message){
        getLog(Level.INFO, message);
    }
    public void info(String message, Object... params){
        info(String.format(message, params));
    }


    public void warning(String message){
        getLog(Level.WARNING, message);
    }
    public void warning(String message, Object... params){
        warning(String.format(message, params));
    }


    public void error(String message){
        getLog(Level.ERROR, message);
    }
    public void error(String message, Object... params){
        error(String.format(message, params));
    }

}