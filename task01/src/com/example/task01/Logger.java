package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String _name;
    private LogSeverityLvl _severityLvl;
    private final Date _date;
    private static final Map<String, Logger> map = new HashMap<>();

    public Logger(String name) {
        _name = name; _severityLvl = LogSeverityLvl.DEBUG; _date = new Date();
    }

    public String getName() { return _name; }

    public void setLevel(LogSeverityLvl lvl) { _severityLvl = lvl; }

    public LogSeverityLvl getLevel() { return _severityLvl; }

    public void log(LogSeverityLvl lvl, String message) throws Exception {
        switch(lvl)
        {
            case DEBUG:
                debug(message);     break;
            case INFO:
                info(message);      break;
            case WARNING:
                warning(message);   break;
            case ERROR:
                error(message);     break;
            default:
                throw new Exception("Такого уровня важности не существует!");
        }
    }

    public void log(LogSeverityLvl lvl, String format, Object ... params) throws Exception {
        switch(lvl)
        {
            case DEBUG:
                debug(format, params);     break;
            case INFO:
                info(format, params);      break;
            case WARNING:
                warning(format, params);   break;
            case ERROR:
                error(format, params);     break;
            default:
                throw new Exception("Такого уровня важности не существует!");
        }
    }

    public void debug(String message) {
        System.out.printf("[%s] %s %s %s - %s%n",
                LogSeverityLvl.DEBUG,
                new SimpleDateFormat("yyyy.MM.dd").format(_date),
                new SimpleDateFormat("hh:mm:ss").format(_date),
                getName(),
                message
        );
    }

    public void debug(String format, Object... params) {
        System.out.printf((format) + "%n", params);
    }

    public void info(String message) {
        System.out.printf("[%s] %s %s %s - %s%n",
                LogSeverityLvl.INFO,
                new SimpleDateFormat("yyyy.MM.dd").format(_date),
                new SimpleDateFormat("hh:mm:ss").format(_date),
                getName(),
                message
        );
    }

    public void info(String format, Object ... params) {
        System.out.printf((format) + "%n", params);
    }

    public void warning(String message) {
        System.out.printf("[%s] %s %s %s - %s%n",
                LogSeverityLvl.WARNING,
                new SimpleDateFormat("yyyy.MM.dd").format(_date),
                new SimpleDateFormat("hh:mm:ss").format(_date),
                getName(),
                message
        );
    }

    public void warning(String format, Object ... params) {
        System.out.printf((format) + "%n", params);
    }

    public void error(String message) {
        System.out.printf("[%s] %s %s %s - %s%n",
                LogSeverityLvl.ERROR,
                new SimpleDateFormat("yyyy.MM.dd").format(_date),
                new SimpleDateFormat("hh:mm:ss").format(_date),
                getName(),
                message
        );
    }

    public void error(String format, Object ... params) {
        System.out.printf((format) + "%n", params);
    }

    public static Logger getLogger(String name) {
        if(map.containsKey(name)) return  map.get(name);

        Logger logger = new Logger(name);
        map.put(name, logger);
        return logger;
    }
}
