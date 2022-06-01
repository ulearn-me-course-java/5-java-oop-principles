package com.example.task04;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

enum ErrorLevel {

    DEBUG,
    INFO,
    WARNING,
    ERROR

}

public class Logger {

    private String Name;
    private ErrorLevel Level;

    public static HashMap<String,Logger> loggers = new HashMap<>();

    public Logger(String name)
    {
        Name = name;
    }

    public Logger(String name, ErrorLevel level)
    {
        Name = name;
        Level = level;
    }

    public ErrorLevel getLevel()
    {
        return Level;
    }

    public void setLevel(ErrorLevel level)
    {
        Level = level;
    }

    public String getName()
    {
        return Name;
    }

    public static Logger getLogger(String name)
    {
        if(loggers.containsKey(name))
            return loggers.get(name);
        return new Logger(name);
    }

    private void showLogMessage(ErrorLevel level, String message){
        if(level.ordinal() >= Level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), Name, message));
    }

    private void getLog(ErrorLevel level, String message)
    {
        showLogMessage(level, message);
    }

    public void debug(String message){
        getLog(ErrorLevel.DEBUG, message);
    }
    public void debug(String message, Object... params){
        debug(String.format(message, params));
    }

    public void info(String message){
        getLog(ErrorLevel.INFO, message);
    }
    public void info(String message, Object... params){
        info(String.format(message, params));
    }

    public void warning(String message){
        getLog(ErrorLevel.WARNING, message);
    }
    public void warning(String message, Object... params){
        warning(String.format(message, params));
    }

    public void error(String message){
        getLog(ErrorLevel.ERROR, message);
    }
    public void error(String message, Object... params){
        error(String.format(message, params));
    }

}

