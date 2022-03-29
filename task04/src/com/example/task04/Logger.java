package com.example.task04;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

enum Levels {
    DEBUG, INFO, WARNING, ERROR
}

class Logger {
    private static final HashMap<String, Logger> logServer = new HashMap();
    private final String name;
    private Levels level;

    public Logger(String name) {
        this.name = name;
        logServer.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return logServer.get(name);
    }

    private void debug(String message) {
        System.out.println(message);
    }

    private void debug(String message, Object... params) {
        debug(String.format(message, params));
    }

    private void info(String message) {
        System.out.println(message);
    }

    private void info(String message, Object... params) {
        info(String.format(message, params));
    }

    private void warning(String message) {
        System.out.println(message);
    }

    private void warning(String message, Object... params) {
        warning(String.format(message, params));
    }

    private void error(String message) {
        System.out.println(message);
    }

    private void error(String message, Object... params) {
        error(String.format(message, params));
    }

    private void log(Levels level, String message) {
        showMassage(level, message);
    }

    private void showMassage(Levels level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            MessageFormat form = new MessageFormat("[{0}] {1} {2} - {3}");
            Object[] loggerMessage = {level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"), name, message};
            System.out.println(form.format(loggerMessage));
        }
    }

    public void log(Levels level, MessageFormat form, Object... params) {
        log(level, form.format(params));
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public Levels getLevel() {
        return level;
    }
}