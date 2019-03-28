package com.example.task04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {
    public final String name;
    public static Map<String, Logger> loggersName = new HashMap<>();
    private static List<MessageHandler> handlers = new ArrayList<>();
    private LevelOfImportance level;


    private Logger(String name) {
        this.name = name;
        loggersName.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return loggersName.containsKey(name) ? loggersName.get(name)
                : new Logger(name);
    }

    public void setLevel(LevelOfImportance level) {
        this.level = level;
    }

    public LevelOfImportance getLevel() {
        return this.level;
    }

    public void debug(String message) {
        log(LevelOfImportance.DEBUG, message);
    }

    public void debug(String format, Object... args) {
        log(LevelOfImportance.DEBUG, format, args);
    }

    public void info(String message) {
        log(LevelOfImportance.INFO, message);
    }

    public void info(String format, Object... args) {
        log(LevelOfImportance.INFO, format, args);
    }

    public void warning(String message) {
        log(LevelOfImportance.WARNING, message);
    }

    public void warning(String format, Object... args) {
        log(LevelOfImportance.WARNING, format, args);
    }

    public void error(String message) {
        log(LevelOfImportance.ERROR, message);
    }

    public void error(String format, Object... args) {
        log(LevelOfImportance.ERROR, format, args);
    }

    public void log(LevelOfImportance level, String message){
        if(this.level == null || (level != null && level.compareTo(this.level) <= 0)){
            DateFormat dateFormat = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
            Date date = new Date();

            for (MessageHandler handle : handlers) {
                handle.showMessage(String.format("[%s] %s %s - %s", level, dateFormat.format(date), name, message));
            }
        }

    }

    public void log(LevelOfImportance level, String format, Object... args){
        log(level, String.format(format, args));
    }

    public void addHandler(MessageHandler handler){
        if (handler != null) {
            handlers.add(handler);
        }
    }
}
