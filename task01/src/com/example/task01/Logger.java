package com.example.task01;
import java.util.HashMap;
import java.util.Map;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {
    public enum Level{
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    private final String name;
    private Level level;

    private static final Map<String, Logger> loggerMap = new HashMap<>();

    public Logger(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public Level getLevel(){
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public static Logger getLogger(String name){
        Logger logger = loggerMap.get(name);
        if (logger == null) {
            loggerMap.put(name, logger = new Logger(name));
        }
        return logger;
    }

    public void log(Level level, String message, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, MessageFormat.format(message, args)));
        }
    }

    public void log(Level level, String message) {
        log(level, message, new Object[0]);
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
