package com.example.task01;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    private final String name;
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private Lvl lvl;

    enum Lvl {
        DEBUG,
        INFO,
        WARNING,
        ERROR

    }

    public Logger(String name) {
        this.name = name;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name) {
        return (loggers.containsKey(name)) ? loggers.get(name) : new Logger(name);
    }
    public  String getName(){
        return name;
    }
    public void setLevel(Lvl level){
        this.lvl = level;
    }

    public Lvl getLevel(){
        return lvl;
    }
    public void debug(String template, Object... args){
        log(Lvl.DEBUG, template, args);
    }

    public void info(String template, Object... args){
        log(Lvl.INFO, template, args);
    }

    public void warning(String template, Object... args){
        log(Lvl.WARNING, template, args);
    }

    public void error(String template, Object... args){
        log(Lvl.ERROR, template, args);
    }

    public void debug(String message){
        log(Lvl.DEBUG, message);
    }

    public void info(String message){
        log(Lvl.INFO, message);
    }

    public void warning(String message){
        log(Lvl.WARNING, message);
    }

    public void error(String message){
        log(Lvl.ERROR, message);
    }

    public void log(Lvl level, String template, Object... args){
        log(level, MessageFormat.format(template, args));
    }

    public void log(Lvl level, String message){
        System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, dateFormat.format(new Date()), name, message));
    }
}
