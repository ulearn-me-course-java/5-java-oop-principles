package com.example.task01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {
    private static ArrayList<Logger> loggers = new ArrayList<>();
    private String name;

    public Logger(String name){
        this.name = name;
        Logger.loggers.add(this);
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String _name){
        Logger fLogger = null;

        for(Logger logger : loggers){
            if (logger.getName().equals(_name)) {
                fLogger = logger;
                break;
            }
        }

        return fLogger;
    }

    public void log(Level level, String message){
        System.out.printf(
                "[%s] %s %s - %s%n", level, getDateTime(), getName(), message
        );
    }

    public void log(Level level, String message, Object... args){
        String someStr = String.format("[%s] %s %s - ", level, getDateTime(), getName());
        System.out.printf(someStr + (message) + "%n", args);
    }

    public String getDateTime(){
        Date date =  new Date();
        String pattern = "yyyy.MM.dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);

        return df.format(date);
    }
}
