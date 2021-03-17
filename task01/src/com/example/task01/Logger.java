package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

enum levels{
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {

    private static ArrayList<Logger> logs = new ArrayList<>();
    private String _name;
    private levels level;

    public Logger(String name){
        this._name = name;
        logs.add(this);
    }

    public String getName(){
        return this._name;
    }

    public levels getLevel(){
        return this.level;
    }

    public void setLevel(levels lvl){
        this.level = lvl;
    }

    public static Logger getLogger(String name){
        return (Logger) logs.stream().filter(x-> x._name.equals(name)).toArray()[0];
    }

    public void log(levels lvl, String message){
        System.out.println(String.format("[%s] %s %s - %s", level, getCurrentTime(), _name, message));
    }

    public void log(levels lvl, String template, Object... args){
        System.out.printf((template) + "%n", args);
    }

    public String getCurrentTime(){
        String dateTime = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
        return dateTime;
    }

    private void debug(String message){
        log(levels.DEBUG, message);
    }

    private void debug(String template, Object... args){
        log(levels.DEBUG, template, args);
    }

    private void info(String message){
        log(levels.INFO, message);
    }

    private void info(String template, Object... args){
        log(levels.INFO, template, args);
    }

    private void warning(String message){
        log(levels.WARNING, message);
    }

    private void warning(String template, Object... args){
        log(levels.WARNING, template, args);
    }

    private void error(String message){
        log(levels.ERROR, message);
    }


    private void error(String template, Object... args){
        log(levels.ERROR, template, args);
    }




}
