package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {

    static ArrayList<Logger> logList=new ArrayList<Logger>();
    private Levels level=Levels.DEBUG;
    private String name;
    private MessageHandler messageHandler;

    public Logger(String name, MessageHandler messageHandler){
        this.name=name;
        this.messageHandler=messageHandler;
        logList.add(this);
    }

    public enum Levels{
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        for(Logger l:logList)
            if(l.getName()==name)
                return l;
        return null;
    }

    public void setLevel(Levels level){
        this.level=level;
    }

    public Levels getLevel(){
        return level;
    }

    public void debug(String message){
        log(Levels.DEBUG, message);
    }

    public void debug(String template, Object... params){
        log(Levels.DEBUG, template, params);
    }

    public void info(String message){
        log(Levels.INFO, message);
    }

    public void info(String template, Object... params){
        log(Levels.INFO, template, params);
    }

    public void warning(String message){
        log(Levels.WARNING, message);
    }

    public void warning(String template, Object... params){
        log(Levels.WARNING, template, params);
    }

    public void error(String message){
        log(Levels.ERROR, message);
    }

    public void error(String template, Object... params){
        log(Levels.ERROR, template, params);
    }

    public void log(Levels level, String message){
        if(level.ordinal() >= this.level.ordinal()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY.MM.DD hh:mm:ss");
            messageHandler.log(String.format("[%s] %s %s - %s", level, dateFormat.format(new Date()), name, message));
        }
    }

    public void log(Levels level, String template, Object... params){
        log(level, String.format(template, params));
    }

}
