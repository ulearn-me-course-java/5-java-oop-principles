package com.example.task01;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    private String Level;
    public void setLevel(String level){
        Level = level;
    }
    public String getLevel(){
        return Level;
    }
    public void log(String level, String message){
        System.out.println("[" + level + "]" + " " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"))
                + " " + this.Name + " - " + message);
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