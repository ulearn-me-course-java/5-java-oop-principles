package com.example.task04;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    private final String name;
    private importanceLevel level;
    private static final Map<String, Logger> loggers = new HashMap<>();
    private static final ArrayList<MessageHandler> handlers = new ArrayList<>();

    public Logger(String name){
        this.name = name;
        this.level = importanceLevel.INFO;
        loggers.put(name, this);
        handlers.add(new ConsoleHandler());
    }


    public void setLevel(importanceLevel level){
        this.level = level;
    }

    public importanceLevel getLevel(){
        return level;
    }

    public String getName(){
        return name ;
    }
    public static Logger getLogger(String name){

        if (loggers.containsKey(name)){
            return loggers.get(name);
        }
        return new Logger(name);
    }


    public void log(importanceLevel level, String message){
        if (level.ordinal() >= this.level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printMessage = String.format("[%s] %s %s - %s", level, date, name, message);

            for (MessageHandler messageHandler : handlers) {
                messageHandler.log(printMessage);
            }
        }
    }

    public void log(importanceLevel level, String message, Object... params ){
        if (level.ordinal() >= this.level.ordinal()) {
            String format = String.format(message, params);
            for (MessageHandler messageHandler : handlers) {
                messageHandler.log(format);
            }
        }
    }


    public void debug(String message){
        log(importanceLevel.DEBUG, message);
    }

    public void debug(String massage, Object... params){
        log(importanceLevel.DEBUG, massage, params);
    }

    public void info(String message){
        log(importanceLevel.INFO, message);
    }

    public void info(String massage, Object... params){
        log(importanceLevel.INFO, massage, params);
    }

    public void warning(String message){
        log(importanceLevel.WARNING, message);
    }

    public void warning(String massage, Object... params){
        log(importanceLevel.WARNING, massage, params);
    }

    public void error(String message){
        log(importanceLevel.ERROR, message);
    }

    public void error(String massage, Object... params){
        log(importanceLevel.ERROR, massage, params);
    }
}
