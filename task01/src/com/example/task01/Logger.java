package com.example.task01;

import javax.annotation.processing.SupportedSourceVersion;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private String name;
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private Level level;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public Logger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return loggers.containsKey(name) ? loggers.get(name) : new Logger(name);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public void log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, dateFormat.format(new Date()), name, message));
    }

    public void log(Level level, String message, Object... params) {
        log(level, MessageFormat.format(message, params));
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
}
