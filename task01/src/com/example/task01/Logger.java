package com.example.task01;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.Date;

public class Logger {

    private String name;
    private Date data;
    private String message;

    enum Levels {DEBUG, INFO, WARNING, ERROR};

    public Logger(String name){
        this.name = name;
    }

    public String getName(){ return name; }
    public String getLevel(){ return level.getNameLevel(); }
    public String getData(){ return data.toString(); }
    public String getMessage(){ return message; }
    public static Logger getLogger(String name){ return new Logger(name); }

    public void setLevel(String level){ this.level = level; }

    public void debug(String message){
        this.message = message;
    }
    public void debug(String pattern, Object... args){
        debug(String.format(message, args));
    }
    public void info(String message){
        this.message = message;
    }
    public void info(String pattern, Object... args){
        info(String.format(message, args));
    }
    public void warning(String message){
        this.message = message;
    }
    public void warning(String pattern, Object... args ){
        warning(String.format(message, args));
    }
    public void error(String message){
        this.message = message;
    }
    public void error(String pattern, Object... args){
        error(String.format(message, args));
    }
}
