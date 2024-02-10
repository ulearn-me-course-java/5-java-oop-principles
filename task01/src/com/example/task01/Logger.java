package com.example.task01;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private final String name;
    private Level level = Level.INFO;
    private static final Map<String, Logger> loggers = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        loggers.put(name,this);
    }
    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        if (!loggers.containsKey(name))
            throw new IllegalArgumentException("There is no logger with that name");
        return loggers.get(name);
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public Level getLevel(){
        return level;
    }

    public void info(String message){
        log(Level.INFO, message);
    }
    public void info(String format, Object... args){
        log(Level.INFO, format, args);
    }
    public void debug(String message){
        log(Level.DEBUG, message);
    }
    public void debug(String format, Object... args){
        log(Level.DEBUG, format, args);
    }
    public void error(String message){
        log(Level.ERROR, message);
    }
    public void error(String format, Object... args){
        log(Level.ERROR, format, args);
    }
    public void warning(String message){
        log(Level.WARNING, message);
    }
    public void warning(String format, Object... args){
        log(Level.WARNING, format, args);
    }
    public void log(Level level, String message){
        if (this.level == level){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String date = dateFormat.format(new Date());
            String time = timeFormat.format(new Date());
            System.out.println(String.format("[%s] %s %s %s - %s", level, date, time, name, message));;
        }
    }

    public void log(Level level, String format, Object... args) {
        log(level, String.format(format, args));
    }
}
