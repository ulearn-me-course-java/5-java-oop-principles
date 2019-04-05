package com.example.task01;

import javax.print.DocFlavor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Logger {

    private static List<Logger> loggers = new ArrayList<>();
    public  static Logger getLogger(String name){
        for(Logger logger : loggers) {
            if (logger.getName() == name)
                return logger;
        }

        return new Logger(name);
    }


    private String _name;
    private MessageLevel _msgLevel = MessageLevel.DEBUG;

    public Logger(String name) {

        if(loggers.contains(name))
            throw new IllegalArgumentException("Logger with this name already exists");

        _name = name;

        loggers.add(this);
    }


    public String getName(){
        return  _name;
    }

    public MessageLevel getLevel(){
        return _msgLevel;
    }

    public void setLevel(MessageLevel level){
        _msgLevel = level;
    }


    public void debug(String message){
        log(MessageLevel.DEBUG, message);
    }

    public void debug(String format, Object... objects){
        log(MessageLevel.DEBUG, format, objects);
    }

    public void info(String message){
        log(MessageLevel.INFO, message);
    }

    public void info(String format, Object... objects){
        log(MessageLevel.INFO, format, objects);
    }

    public void warning(String message){
        log(MessageLevel.WARNING, message);
    }

    public void warning(String format, Object... objects){
        log(MessageLevel.WARNING, format, objects);
    }

    public void error(String message){
        log(MessageLevel.ERROR, message);
    }

    public void error(String format, Object... objects){
        log(MessageLevel.ERROR, format, objects);
    }

    public void log(MessageLevel msgLevel, String format, Object... objects){
        log(msgLevel, String.format(format, objects));
    }

    public void log(MessageLevel msgLevel, String message){

        if(MessageUtil.GetValue(msgLevel) < MessageUtil.GetValue(_msgLevel))
            return;

        String LEVEL = "[" + MessageUtil.toString(msgLevel) + "]";
        String DATE = new SimpleDateFormat("YYYY.MM.DD").format(new Date());
        String TIME = new SimpleDateFormat("HH:mm:ss").format(new Date());

        System.out.println(LEVEL + " " + DATE + " " + TIME + " " + _name + " - " + message);
    }


    protected void finalize ( ) {
        loggers.remove(this);
    }
}

