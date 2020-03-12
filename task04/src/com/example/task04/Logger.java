package com.example.task04;

import com.example.task04.MessageHandler;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

enum Level{
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private MessageHandler handler;
    private String name;
    private Level lvl;
    private static Logger loggers[] = new Logger[0];
    private static int loggersCount;

    public Logger(String name){
        this.name = name;
        loggersCount++;
        loggers = Arrays.copyOf(loggers, loggersCount);
        loggers[loggersCount - 1] = this;
    }

    public static Logger getLogger(String name){
        for (Logger logger : loggers) {
            if (logger.name.equals(name)) return logger;
        }
        return new Logger(name);
    }

    public String getName(){
        return name;
    }

    public void setLevel(Level lvl)
    {
        this.lvl = lvl;
    }

    public Level getLevel() {
        return lvl;
    }

    public void log(Level level, String message) {
        log(level, message, null);
    }

    public void log(Level level, String message, Object... args) {
        String logMessage = String.format("[%s] %s %s %s - %s", level, getDate(), getTime(), name, message);
        System.out.println(logMessage);
    }

    private String getTime() {
        Date timeNow = new Date();
        SimpleDateFormat formatForTimeNow = new SimpleDateFormat("hh:mm:ss");
        return formatForTimeNow.format(timeNow);
    }

    private String getDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        return formatForDateNow.format(dateNow);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(Level.DEBUG, message, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(Level.WARNING, message, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(Level.ERROR, message, args);
    }
}
