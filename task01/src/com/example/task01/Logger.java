package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private PriorityLevel level;

    public Logger(String name){
        this.name = name;
        level = PriorityLevel.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, PriorityLevel level){
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }

    public String getName(){
        return name;
    }

    public PriorityLevel getLevel(){
        return level;
    }

    public void setLevel(PriorityLevel level){
        this.level = level;
    }

    public static Logger getLogger(String name){
        if(!loggers.containsKey(name))
            loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public void debug(String message){
        log(PriorityLevel.DEBUG, message);
    }

    public void debug(String format, Object... objects){
        log(PriorityLevel.DEBUG, format, objects);
    }

    public void info(String message){
        log(PriorityLevel.INFO, message);
    }

    public void info(String format, Object... objects){
        log(PriorityLevel.INFO, format, objects);
    }

    public void warning(String message){
        log(PriorityLevel.WARNING, message);
    }

    public void warning(String format, Object... objects){
        log(PriorityLevel.WARNING, format, objects);
    }

    public void error(String message){
        log(PriorityLevel.ERROR, message);
    }

    public void error(String format, Object... objects){
        log(PriorityLevel.ERROR, format, objects);
    }

    public void log(PriorityLevel loglevel, String message){
        if(this.level.ordinal() <= loglevel.ordinal()) {
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", loglevel, data, name, message));
        }
    }

    public void log(PriorityLevel loglevel, String format, Object... objects){
        if(this.level.ordinal() <= loglevel.ordinal()) {
            System.out.println(MessageFormat.format(format, objects));
        }
    }
}
