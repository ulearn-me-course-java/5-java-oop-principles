package com.example.task04;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {
    private String name;
    private Level level;
    private ArrayList<MessageHandler> messageHandlers;
    public static Map<String, Logger> loggerMap = new Hashtable<>();
    public Logger(String name){
        loggerMap.put(name, this);
        this.name = name;
        messageHandlers = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public static Logger getLogger(String name){
        Logger logger = loggerMap.get(name);
        if (logger == null){
            return new Logger(name);
        }
        return logger;
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public Level getLevel(){
        return level;
    }
    public String error(String message){
        return log(Level.ERROR, message);
    }
    public String error(String format, Object...args){
        return log(Level.ERROR, format, args);
    }
    public String info(String message){
        return log(Level.INFO, message);
    }
    public String info(String format, Object...args){
        return log(Level.INFO, format, args);
    }
    public String debug(String message){
        return log(Level.DEBUG, message);
    }
    public String debug(String format, Object...args){
        return log(Level.DEBUG, format, args);
    }
    public String warning(String message){
        return log(Level.WARNING, message);
    }
    public String warning(String format, Object...args){
        return log(Level.WARNING, format, args);
    }
    public String log(Level level, String message){
        if (this.level.currency >= level.currency){
            Date date = new Date();
            RecordLog recordLog = new RecordLog(level,message);
            recordLog.setLoggerName(name);
            recordLog.setDate(date);
            if (!messageHandlers.isEmpty()){
                for (MessageHandler item: messageHandlers) {
                    item.publish(recordLog);
                }
            }
            return recordLog.getLogMessage();
        }
        return "";
    }
    public String log(Level level, String format, Object...args){
        if (this.level.currency >= level.currency){
            String message = String.format(format, args);
            Date date = new Date();
            RecordLog recordLog = new RecordLog(level,message);
            recordLog.setLoggerName(name);
            recordLog.setDate(date);
            if (!messageHandlers.isEmpty()){
                for (MessageHandler item: messageHandlers) {
                    item.publish(recordLog);
                }
            }
            return recordLog.getLogMessage();
        }
        return "";
    }
    public void addMessageHandler(MessageHandler messageHandler){
        messageHandlers.add(messageHandler);
    }
    public void removeMessageHandler(MessageHandler messageHandler){
        messageHandlers.remove(messageHandler);
    }
}
enum Level{
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),;
    int currency;
    Level(int currency) {
        this.currency = currency;
    }
    Level(){}
}
