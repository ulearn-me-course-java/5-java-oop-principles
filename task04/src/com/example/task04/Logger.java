package com.example.task04;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Logger {
    public static Map<String, Logger> Logger = new HashMap<>();

    private String className;
    private List<Log> logs = new ArrayList<>();
    private Level currentLevel = Level.DEBUG;

    public List<Log> getLogs() {
        List<Log> result = new ArrayList<Log>();
        for(Log log : logs){
            result.add(log);
        }
        return  result;
    }

    public void eraseLogs() {
        logs = new ArrayList<>();
    }

    private Logger(String className){
        this.className = className;
    }

    public String getName() {
        return className;
    }

    public void setLevel(Level level){
        currentLevel = level;
    }

    public String getLevel(){
        return currentLevel.toString();
    }

    public static Logger getLogger(String name){
        if(!Logger.containsKey(name))
            Logger.put(name, new Logger(name));
        return Logger.get(name);
    }

    public void log(Level level, String message){
        logs.add(new Log(this.className, new Date(), message, level));
    }

    public void log(Level level, String format, Object... args) {
        log(level, String.format(format, args));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... args) {
        log(Level.DEBUG, format, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String format, Object... args) {
        log(Level.INFO, format, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... args) {
        log(Level.WARNING, format, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String format, Object... args) {
        log(Level.ERROR, format, args);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Log log : logs) {
            if(log.level.ordinal() >= currentLevel.ordinal())
                sb.append(log);
        }
        return sb.toString();
    }
}