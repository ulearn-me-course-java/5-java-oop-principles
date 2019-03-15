package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class Logger {
    private static Map<String, Logger> loggerInstances = new HashMap<>();
    private final String name;
    private Level level;
    private final String pattern = "[%s] %s %s - %s";

    private Logger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name){
        if (loggerInstances.containsKey(name))
            return loggerInstances.get(name);
        Logger instance = new Logger(name);
        loggerInstances.put(name, instance);
        return instance;
    }

    public boolean isLoggable(Level level){
        return this.level == null || level.getValue() >= this.level.getValue();
    }

    public void log(Level level, String message){
        //Сообщение, чей уровень важности ниже установленного не должны печататься в консоль.
        if(isLoggable(level)) {
            out.println(String.format(pattern,
                    level,
                    currentDate(),
                    name,
                    message));
        }
    }

    public void log(Level level, String format, Object... args){
        if(isLoggable(level)) {
            out.println(String.format(pattern,
                    level,
                    name,
                    currentDate(),
                    String.format(format, args)));
        }
    }

    private String currentDate(){
        return new SimpleDateFormat("YYYY.MM.DD hh:mm:ss")
                .format(new Date());
    }

    public void debug(String message){
        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... args){
        log(Level.DEBUG, format, args);
    }

    public void info(String message){
        log(Level.INFO, message);
    }

    public void info(String format, Object... args){
        log(Level.INFO, format, args);
    }

    public void warning(String message){
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... args){
        log(Level.WARNING, format, args);
    }

    public void error(String message){
        log(Level.ERROR, message);
    }

    public void error(String format, Object... args){
        log(Level.ERROR, format, args);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
