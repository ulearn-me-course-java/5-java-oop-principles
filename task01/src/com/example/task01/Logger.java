package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String _name;
    private LogSeverityLvl _currentLvl;
    private static final Map<String, Logger> map = new HashMap<>();

    public Logger(String name) {
        _name = name; _currentLvl = LogSeverityLvl.DEBUG;
    }

    public String getName() { return _name; }

    public void setLevel(LogSeverityLvl lvl) { _currentLvl = lvl; }

    public LogSeverityLvl getLevel() { return _currentLvl; }

    public void log(LogSeverityLvl lvl, String message) {
        printMessage(lvl, message);
    }

    public void log(LogSeverityLvl lvl, String format, Object ... params) {
        printMessage(lvl, format, params);
    }

    public void debug(String message) {
        printMessage(LogSeverityLvl.DEBUG, message);
    }

    public void debug(String format, Object... params) {
        printMessage(LogSeverityLvl.DEBUG, format, params);
    }

    public void info(String message) {
        printMessage(LogSeverityLvl.INFO, message);
    }

    public void info(String format, Object ... params) {
        printMessage(LogSeverityLvl.INFO, format, params);
    }

    public void warning(String message) {
        printMessage(LogSeverityLvl.WARNING, message);
    }

    public void warning(String format, Object ... params) {
        printMessage(LogSeverityLvl.WARNING, format, params);
    }

    public void error(String message) {
        printMessage(LogSeverityLvl.ERROR, message);
    }

    public void error(String format, Object ... params) {
        printMessage(LogSeverityLvl.ERROR, format, params);
    }

    private void printMessage(LogSeverityLvl lvl, String message) {
        if(_currentLvl.ordinal() > lvl.ordinal()) return;

        System.out.printf("[%s] %s %s - %s%n",
                lvl,
                new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date()),
                getName(),
                message
        );
    }

    private void printMessage(LogSeverityLvl lvl, String format, Object... params) {
        if(_currentLvl.ordinal() > lvl.ordinal()) return;

        System.out.printf((format) + "%n", params);
    }

    public static Logger getLogger(String name) {
        if(map.containsKey(name)) return  map.get(name);

        Logger logger = new Logger(name);
        map.put(name, logger);
        return logger;
    }
}
