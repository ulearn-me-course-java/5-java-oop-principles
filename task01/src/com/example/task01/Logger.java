package com.example.task01;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Logger {
    public static final List<Pair> loggers = new ArrayList<>();
    public String Name;
    public String getName(){
        return Name;
    }
    public Logger(String name) {
        this.Name = name;
        loggers.add(new Pair(this.Name, this));
    }
    public static Logger getLogger(String name){
        for (Pair pair: loggers) {
            if(pair.Name == name) {
                return pair.logger;
            }
        }
        return new Logger(name);
    }
    private String Level = "DEBUG";
    public void setLevel(String level){
        Level = level;
    }
    public String getLevel(){
        return Level;
    }
    public static int levelToInt(String level){
        switch (level) {
            case "DEBUG":
                return 1;
            case "INFO":
                return 2;
            case "WARNING":
                return 3;
            case "ERROR":
                return 4;
            default:
                return 0;
        }
    }
    public void log(String level, String message){
            if (levelToInt(level) >= levelToInt(this.getLevel())) {
                System.out.println("[" + level + "]" + " " +
                        new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date())
                        + " " + this.Name + " - " + message);
            }
        }
    public void log(String level, String format, Object... params) {
        log(level, String.format(format, params));
    }

    public void debug(String message) {
        log("DEBUG", message);
    }

    public void debug(String format, Object... params) {
        debug(String.format(format, params));
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void info(String format, Object... params) {
        info(String.format(format, params));
    }

    public void warning(String message) {
        log("WARNING", message);
    }

    public void warning(String format, Object... params) {
        warning(String.format(format, params));
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public void error(String format, Object... params) {
        error(String.format(format, params));
    }
}