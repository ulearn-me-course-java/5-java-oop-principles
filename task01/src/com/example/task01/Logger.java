package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

enum MessageLevel {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {

    public static HashMap<String, Logger> loggers;
    private String name;
    private MessageLevel level;

    public Logger(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        return loggers.get(name);
    }

    public void setLevel(MessageLevel level){
        this.level = level;
    }

    public MessageLevel getLevel(){
        return this.level;
    }

    public void logMessageOutput(MessageLevel level, String message){
        if(level.ordinal() >= this.level.ordinal()){
            System.out.println(MessageFormat.format("[{0}] {1} {2}: =^._.^= {3}", level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
        }
    }

    public void log(MessageLevel level, String message){
        logMessageOutput(level, message);
    }

    public void log(MessageLevel level, MessageFormat output, Object... args){
        log(level, output.format(args));
    }

    public void debug(String message){
        System.out.println(message);
    }

    public void debug(String message, Object... args){
        debug(String.format(message, args));
    }

    public void info(String message){
        System.out.println(message);
    }

    public void info(String message, Object... args){
        info(String.format(message, args));
    }

    public void warning(String message){
        System.out.println(message);
    }

    public void warning(String message, Object... args){
        warning(String.format(message, args));
    }

    public void error(String message){
        System.out.println(message);
    }

    public void error(String message, Object... args){
        error(String.format(message, args));
    }

}
