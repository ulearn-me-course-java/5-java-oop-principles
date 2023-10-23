package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    public enum LogLevel{
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    private final String name;
    private LogLevel logLevel = LogLevel.DEBUG;
    private static HashMap<String, Logger> loggers = new HashMap<>();

    private Logger(String nameLogger){
        this.name = nameLogger;
        this.logLevel = LogLevel.DEBUG;
        loggers.put(name, this);
    }
    public Logger(String name, LogLevel level) {
        this.name = name;
        this.logLevel = level;
        loggers.put(name, this);
    }
    public String getName() { return name;}
    public static Logger getLogger(String name){  if (loggers.containsKey(name))
        return loggers.get(name);
        return new Logger(name);}

    public void setLevel(LogLevel level){ this.logLevel = level; }
    public LogLevel getLevel(){ return this.logLevel; }
    public void  log(LogLevel level, String message) {
        if (level.ordinal() >= this.logLevel.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }    }
    public void log(LogLevel logLevel, String pattern, Object... args ){
        if (logLevel.ordinal() >= this.logLevel.ordinal() ){
            System.out.println(MessageFormat.format(pattern, args));
        }

    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String template, Object... args) {
        log(LogLevel.INFO, template, args);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(LogLevel.DEBUG, template, args);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(LogLevel.WARNING, template, args);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(LogLevel.ERROR, template, args);
    }
}

