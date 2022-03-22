package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {
    private Date dateNow = new Date();
    private SimpleDateFormat date = new SimpleDateFormat("yyyy.mm.dd");
    private SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
    private LogLevel level;
    private String name;
    private MessageHandler handler = new ConsoleHandler();

    private static HashMap<String, Logger> logs = new HashMap<>();

    public Logger(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void setHandler(MessageHandler handler) {
        this.handler = handler;
    }

    public LogLevel getLevel() {
        return level;
    }

    public static Logger getLogger(String name){
        if(logs.containsKey(name))
            return logs.get(name);
        return new Logger(name);
    }

    public void log(LogLevel level, String pattern, Object... args){
        System.out.println(String.format("[%s] %s %s %s - %s",
                level, date.format(dateNow), time.format(dateNow), name, String.format(pattern, args)));
    }

    private void log(LogLevel level, String message){
        log(level, message, new Object[0]);
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }

    public void debug(String message, Object... args){
        debug(String.format(message, args));
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }

    public void info(String message, Object... args){
        info(String.format(message, args));
    }

    public void warning(String message){
        log(LogLevel.WARNING, message);
    }

    public void warning(String message, Object... args){
        warning(String.format(message, args));
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }

    public void error(String message, Object... args){
        error(String.format(message, args));
    }
}
