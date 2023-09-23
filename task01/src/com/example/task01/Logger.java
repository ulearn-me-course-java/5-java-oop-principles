package com.example.task01;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;

import static java.text.MessageFormat.format;

public class Logger {
    private String name;
    private ImportanceLevel level;
    private static HashMap<String,Logger> loggerList = new HashMap<String,Logger>();
    public Logger(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public static Logger getLogger(String newName){
        for (String name:
                loggerList.keySet()) {
            if (name==newName){
                return loggerList.get(name);
            }
        }
        Logger newLogger = new Logger(newName);
        loggerList.put(newName,newLogger);
        return newLogger;
    }
    private String log(ImportanceLevel level, String message){
        String res = null;
        if (this.level.ordinal() <= level.ordinal() ){
            res = String.format("[%s] %t %t %s - %s",level.name(), java.time.LocalDate.now(),
                    java.time.LocalTime.now(), getName(), message);
        }
        return res;
    }
    private String log(ImportanceLevel level, String messageFormat ,Object... args){
        String res = null;
        if (this.level.ordinal() <= level.ordinal() ){
            res = String.format("[%s] %t %t %s - %s",level.name(), java.time.LocalDate.now(),
                    java.time.LocalTime.now(), getName(), String.format(messageFormat,args));
        }
        return res;
    }
    public void setLevel(ImportanceLevel level){
        this.level = level;
    }
    public ImportanceLevel getLevel(){
        return level;
    }
    public String debug(String message){
        return log(ImportanceLevel.DEBUG,message);
    }
    public String debug(String messageFormat, Object... args){
        return log(ImportanceLevel.DEBUG,messageFormat, args);
    }
    public String info(String message){
        return log(ImportanceLevel.INFO,message);
    }
    public String info(String messageFormat, Object... args){
        return log(ImportanceLevel.INFO,messageFormat, args);
    }
    public String warning(String message){
        return log(ImportanceLevel.WARNING,message);
    }
    public String warning(String messageFormat, Object... args){
        return log(ImportanceLevel.WARNING,messageFormat, args);
    }
    public String error(String message){
        return log(ImportanceLevel.ERROR,message);
    }
    public String error(String messageFormat, Object... args){
        return log(ImportanceLevel.ERROR,messageFormat, args);
    }
}

