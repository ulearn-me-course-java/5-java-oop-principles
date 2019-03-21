package com.example.task04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {
    public static Map<String, Logger> loggers = new HashMap<>();
    public static List<MessageHandler> handlers = new ArrayList<>();
    private Importance level;
    private final String name;

    public Logger(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addHandler(MessageHandler handler){
        if (handler != null) {
            handlers.add(handler);
        }
    }

    public static Logger getLogger(String name){
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        }
        Logger temp = new Logger(name);
        loggers.put(name, temp);
        return temp;
    }

    public void log(Importance level, String message){
        if(this.level == null || (level != null && level.compareTo(this.level) <= 0)){
            DateFormat dateFormat = new SimpleDateFormat("YYYY.MM.DD hh:mm:ss");
            Date date = new Date();

            for (MessageHandler handle : handlers) {
                handle.printMessage(String.format("[%s] %s %s - %s", level, dateFormat.format(date), name, message));
            }
        }

    }

    public void log(Importance level, String format, Object... args){
        log(level, String.format(format, args));
    }

    public void setLevel(Importance level) {
        this.level = level;
    }

    public Importance getLevel(){
        return this.level;
    }

    public void debug(String message){
        log(Importance.DEBUG, message);
    }
    public void debug(String format, Object... args){
        log(Importance.DEBUG, format, args);
    }

    public void info(String message){
        log(Importance.INFO, message);
    }
    public void info(String format, Object... args){
        log(Importance.INFO, format, args);
    }

    public void warning(String message){
        log(Importance.WARNING, message);
    }
    public void warning(String format, Object... args){
        log(Importance.WARNING, format, args);
    }

    public void error(String message){
        log(Importance.ERROR, message);
    }
    public void error(String format, Object... args){
        log(Importance.ERROR, format, args);
    }
}
