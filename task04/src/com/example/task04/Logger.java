package com.example.task04;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

enum Levels {DEBUG, INFO, WARNING, ERROR}

public class Logger {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")

    private static final Hashtable<String, Logger> logs = new Hashtable<>();

    private final String name;
    private Levels level;

    public Logger(String name, Levels level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public static Logger getLogger(String name) throws Exception {
        if (logs.containsKey(name))
            return logs.get(name);
        else
            throw new Exception("This log doesn't exist!");
    }

    public Levels getLevel() {
        return this.level;
    }

    public void showMsg(Levels level, String message) {
        if(level.ordinal() >= this.level.ordinal()){
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
        }

    }

    public void getLog(Levels level, String message) {
        showMsg(level,message);
    }
    public void debug(String message) {
        showMsg(Levels.DEBUG, message);
    }
    public void debug(String message, Object... params){
        debug(String.format(message, params));
    }
    public void info(String message) {
        showMsg(Levels.INFO, message);
    }
    public void info(String message, Object... params){
        info(String.format(message, params));
    }
    public void warning(String message, Object... params){
        warning(String.format(message, params));
    }
    public void warning(String message) {
        showMsg(Levels.WARNING, message);
    }
    public void error(String message, Object... params){
        error(String.format(message, params));
    }
    public void error(String message) {
        showMsg(Levels.ERROR, message);
    }
}
