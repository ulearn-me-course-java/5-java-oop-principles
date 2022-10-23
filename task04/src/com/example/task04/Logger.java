package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String _name;
    private LogSeverityLvl _currentLvl;
    private MessageHandler[] handlers;
    private static final Map<String, Logger> map = new HashMap<>();
    public Logger(String name) {
        _name = name; _currentLvl = LogSeverityLvl.DEBUG; handlers = new MessageHandler[] { new ConsoleHandler() };
    }

    public String getName() { return _name; }

    public void setHandlers(MessageHandler[] handlers) {
        this.handlers = handlers;
    }

    public MessageHandler[] getHandlers() {
        return handlers.clone();
    }

    public void setLevel(LogSeverityLvl lvl) { _currentLvl = lvl; }

    public LogSeverityLvl getLevel() { return _currentLvl; }

    public void log(LogSeverityLvl lvl, String message) {
        printMessage(lvl, message);
    }

    public void log(LogSeverityLvl lvl, String format, Object... params) {
        printMessage(lvl, format, handlers, params);
    }

    public void debug(String message) {
        log(LogSeverityLvl.DEBUG, message);
    }

    public void debug(String format, Object... params) {
        log(LogSeverityLvl.DEBUG, format, handlers, params);
    }

    public void info(String message) {
        log(LogSeverityLvl.INFO, message);
    }

    public void info(String format, Object... params) {
        log(LogSeverityLvl.INFO, format, params);
    }

    public void warning(String message) {
        log(LogSeverityLvl.WARNING, message);
    }

    public void warning(String format, Object... params) {
        log(LogSeverityLvl.WARNING, format, params);
    }

    public void error(String message) {
        log(LogSeverityLvl.ERROR, message);
    }

    public void error(String format, Object... params) {
        log(LogSeverityLvl.ERROR, format, params);
    }

    private void printMessage(LogSeverityLvl lvl, String message) {
        if(_currentLvl.ordinal() > lvl.ordinal()) return;

        for(MessageHandler handler : handlers)
            handler.processMessage(_name, lvl, message);
    }

    private void printMessage(LogSeverityLvl lvl, String format, Object... params) {
        if(_currentLvl.ordinal() > lvl.ordinal()) return;

        for(MessageHandler handler : handlers)
            handler.processMessage(format, params);
    }

    public static Logger getLogger(String name) {
        if(map.containsKey(name)) return  map.get(name);

        Logger logger = new Logger(name);
        map.put(name, logger);
        return logger;
    }
}