package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

enum MessageLevel{
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private final String name;
    private Date date;
    private MessageLevel level;
    private static HashMap<String, Logger> AllLogs = new HashMap<>();

    public static Logger newLogger(String name){
        if(!AllLogs.containsKey(name)){
            return new Logger(name);
        }
        return null;
    }

    private Logger(String name){
        this.name = name;
        this.date = new Date();
        this.level = MessageLevel.DEBUG;
        AllLogs.put(name, this);
    }

    public void setLevel(MessageLevel level){
        this.level = level;
    }

    public MessageLevel getLevel(){
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public static Logger getLogger(String name){
        if(AllLogs.containsKey(name))
            return AllLogs.get(name);
        Logger log = new Logger(name);
        AllLogs.put(name, log);
        return log;
    }

    public void log(MessageLevel level, String message){
        printLog(message, level);
    }

    public void log(MessageLevel level, String message, Object... args){
        printLog(String.format(message, args), level);
    }

    private void printLog(String message, MessageLevel level){
        System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level,
                new SimpleDateFormat("YYYY.MM.DD hh:mm:ss").format(this.date), this.name, message));
    }

    public void debug(String message){
        log(MessageLevel.DEBUG, message);
    }

    public void debug(String message, Object... args){
        log(MessageLevel.DEBUG, message, args);
    }

    public void info(String message){
        log(MessageLevel.INFO, message);
    }

    public void info(String message, Object... args){
        log(MessageLevel.INFO, message, args);
    }

    public void warning(String message){
        log(MessageLevel.WARNING, message);
    }

    public void warning(String message, Object... args){
        log(MessageLevel.WARNING, message, args);
    }

    public void error(String message){
        log(MessageLevel.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(MessageLevel.ERROR, message, args);
    }
}
