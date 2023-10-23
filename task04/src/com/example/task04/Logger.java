package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    private final String name;
    private final static HashMap<String, Logger> loggers = new HashMap<>();
    private final ArrayList<MessageHandler> mesHandlers = new ArrayList<>();
    private ImportanceLevel level;

    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
        this.level = ImportanceLevel.DEBUG;
        this.mesHandlers.add(new ConsoleHandler());
    }

    public Logger(String name, ImportanceLevel level, MessageHandler ... handlers) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
        this.mesHandlers.addAll(Arrays.asList(handlers));
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        if (loggers.get(name) == null)
            loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public ImportanceLevel getLevel(){
        return level;
    }

    public void setLevel(ImportanceLevel level){
        this.level = level;
    }

    public void setMesHandlers(MessageHandler ... handlers){
        this.mesHandlers.addAll(Arrays.asList(handlers));
    }

    public void debug(String message){
        log(ImportanceLevel.DEBUG, message);
    }

    public void debug(String format, Object ...objects){
        log(ImportanceLevel.DEBUG, format, objects);
    }

    public void info(String message){
        log(ImportanceLevel.INFO, message);
    }

    public void info(String format, Object ...objects){
        log(ImportanceLevel.INFO, format, objects);
    }

    public void warning(String message){
        log(ImportanceLevel.WARNING, message);
    }

    public void warning(String format, Object ...objects){
        log(ImportanceLevel.WARNING, format, objects);
    }

    public void error(String message){
        log(ImportanceLevel.ERROR, message);
    }

    public void error(String format, Object ...objects){
        log(ImportanceLevel.ERROR, format, objects);
    }

    public void log(ImportanceLevel logLevel, String message){
        if (logLevel.ordinal() >= this.level.ordinal()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            runHandleMessage("[" + logLevel + "] " + formatter.format(date) + " " + this.name + " - " + message);
        }
    }

    public void log(ImportanceLevel logLevel, String format, Object ...objects){
        if (logLevel.ordinal() >= this.level.ordinal()) {
            runHandleMessage(String.format(format, objects));
        }
    }

    private void runHandleMessage(String message){
        for(MessageHandler messageHandler : mesHandlers){
            messageHandler.handleMessage(message);
        }
    }

}
