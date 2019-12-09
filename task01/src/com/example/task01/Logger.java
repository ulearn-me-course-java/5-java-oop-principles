package com.example.task01;

import java.util.*;
import java.text.*;

public class Logger {

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private final String name;
    private Level impLevel = Level.DEBUG;

    private static HashMap<String, Logger> loggers = new HashMap<>();

    private Logger(String name) {
        this.name = name;
    }

    private static Logger createLogger(String name) {
        Logger newLogger = new Logger(name);
        loggers.put(name, newLogger);
        return newLogger;
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        return logger == null ? createLogger(name) : logger;
    }

    public String getName() {
        return name;
    }

    private static String getNowDateFormat() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        return formatForDateNow.format(dateNow);
    }

    private void printMessage(String message, Level impLevel) {
        // printableMessage = "[" + impLevel.name() + "] " + getNowDateFormat() + String.format(" %s - %s", name, message);
        String printableMessage = String.format("[%s] %s %s - %s", impLevel.name(), getNowDateFormat(), name, message);
        System.out.println(printableMessage);
    }

    public void debug(String message) {
        if (impLevel.ordinal() <= Level.DEBUG.ordinal()) {
            printMessage(message, Level.DEBUG);
        }
    }

    public void debug(String format, Object... params) {
        if (impLevel.ordinal() <= Level.DEBUG.ordinal()) {
            printMessage(String.format(format, params), Level.DEBUG);
        }
    }

    public void info(String message) {
        if (impLevel.ordinal() <= Level.INFO.ordinal()) {
            printMessage(message, Level.INFO);
        }
    }

    public void info(String format, Object... params) {
        if (impLevel.ordinal() <= Level.INFO.ordinal()) {
            printMessage(String.format(format, params), Level.INFO);
        }
    }

    public void warning(String message) {
        if (impLevel.ordinal() <= Level.WARNING.ordinal()) {
            printMessage(message, Level.WARNING);
        }
    }

    public void warning(String format, Object... params) {
        if (impLevel.ordinal() <= Level.WARNING.ordinal()) {
            printMessage(String.format(format, params), Level.WARNING);
        }
    }

    public void error(String message) {
        if (impLevel.ordinal() <= Level.ERROR.ordinal()) {
            printMessage(message, Level.ERROR);
        }
    }

    public void error(String format, Object... params) {
        if (impLevel.ordinal() <= Level.ERROR.ordinal()) {
            printMessage(String.format(format, params), Level.ERROR);
        }
    }

    public void log(String message, Level impLevel) {
        if (this.impLevel.ordinal() <= impLevel.ordinal()) {
            printMessage(message, impLevel);
        }
    }

    public void log(String format, Level impLevel, Object... params) {
        if (this.impLevel.ordinal() <= impLevel.ordinal()) {
            printMessage(String.format(format, params), impLevel);
        }
    }

    public Level getLevel() {
        return impLevel;
    }

    public void setLevel(Level impLevel) {
        this.impLevel = impLevel;
    }

}