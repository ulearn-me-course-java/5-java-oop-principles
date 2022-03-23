package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    private LEVEL level;
    private Date date;
    private final String name;
    private static HashMap<String, Logger> loggers = new HashMap<>();

    public Logger(String name){
        this(name, LEVEL.DEBUG);
    }

    public Logger(String name, LEVEL level){
        this.name = name;
        this.level = level;
    }

    public static Logger getLogger(String name) {
        if (!loggers.containsKey(name))
            loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public String getName() {
        return name;
    }

    public enum LEVEL {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public void debug(String text) {
        log(LEVEL.DEBUG, text);
    }

    public void debug(String text, Object... objects) {
        log(LEVEL.DEBUG, text, objects);
    }

    public void info(String text) {
        log(LEVEL.INFO, text);
    }

    public void info(String text, Object... objects) {
        log(LEVEL.INFO, text, objects);
    }

    public void warning(String text) {
        log(LEVEL.WARNING, text);
    }

    public void warning(String text, Object... objects) {
        log(LEVEL.WARNING, text, objects);
    }

    public void error(String text) {
        log(LEVEL.ERROR, text);
    }

    public void error(String text, Object... objects) {
        log(LEVEL.ERROR, text, objects);
    }

    public void setLevel(LEVEL level) {
        this.level = level;
    }

    public LEVEL getLevel() {
        return level;
    }

    public void log(LEVEL level, String text) {
        date = new Date();
        if (level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(date), name, text));
    }

    public void log(LEVEL level, String text, Object... objects) {
        date = new Date();
        if (level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format(text, objects));
    }
}
