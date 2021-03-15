package com.example.task01;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Logger {
    public static Map<String, Logger> Logger = new HashMap<>();

    private class Log {
        public Date date;
        public String message;
        public Level level;

        public Log(Date date, String message, Level level) {
            this.date = date;
            this.message = message;
            this.level = level;
        }

        @Override
        public String toString(){
            String dateTime = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(date);
            return String.format("[%s] %s %s - %s", level, dateTime, className, message);
        }
    }

    private String className;
    private List<Log> logs = new ArrayList<>();
    private Level currentLevel = Level.DEBUG;

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
        logs.add(new Log(new Date(), message, level));
        System.out.println(this);
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
            sb.append(log + "\n");
        }
        return sb.toString();
    }
}
