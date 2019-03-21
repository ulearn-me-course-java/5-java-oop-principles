package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {

    private static Map<String, Logger> loggers = new HashMap<>();
    private final String name;
    private Level level;

    public Logger(String name){
        this.name = name;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name){
        return loggers.containsKey(name) ? loggers.get(name) : new Logger(name);
    }

    public void log(Level level, String message){
        log(level, "%s", message);
    }

    public void log(Level level, String format, Object... objects){
        if(this.level == null || level.ordinal() >= this.level.ordinal())
            System.out.println(String.format(
                    "[%s] %s %s - %s",
                    level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                    name,
                    String.format(format, objects)));
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

    public String getName() {
        return name;
    }
}
