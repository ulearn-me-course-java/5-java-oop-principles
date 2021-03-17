package com.example.task04;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Handler;

public class Logger {
    private Level level = Level.INFO;
    private String name;
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private ArrayList<MessageHandler> handlers = new ArrayList<>();

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        return loggers.containsKey(name) ? loggers.get(name) : new Logger(name);
    }

    public void addHandler(MessageHandler handler){
        handlers.add(handler);
    }

    private String logMessage(Level level, String message){
        if(level.ordinal() >= this.level.ordinal()){
            return  MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                    name,
                    message);
        }
        return null;
    }

    public void debug(String message){
        log(Level.DEBUG, message);
    }
    public void debug(String message, Object... params){
        debug(String.format(message, params));
    }


    public void info(String message){
        log(Level.INFO, message);
    }
    public void info(String message, Object... params){
        info(String.format(message, params));
    }


    public void warning(String message){
        log(Level.WARNING, message);
    }
    public void warning(String message, Object... params){
        warning(String.format(message, params));
    }


    public void error(String message){
        log(Level.ERROR, message);
    }
    public void error(String message, Object... params){
        error(String.format(message, params));
    }


    private void log(Level level, String message){
        for (MessageHandler handler : handlers) {
            String logMess = logMessage(level, message);
            if (logMess != null)
                handler.log(logMess);
        }
    }
    private void log(Level level, String message, Object... params){
        log(level, String.format(message, params));
    }

    public Logger(String name){
        this.name = name;
    }

    public Logger(String name, Level level){
        this.name = name;
        this.level = level;
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public Level getLevel(){
        return level;
    }
}
