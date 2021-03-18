package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.*;

public class MemoryHandler implements MessageHandler {

    private static final Dictionary<String, MemoryHandler> loggers = new Hashtable<>();
    private final String name;
    private Level level;
    private Queue<String> logs;
    private final int bufferSize;

    public MemoryHandler(String name, int bufferSize) {
        this.name = name;
        loggers.put(name, this);
        logs = new ArrayDeque<>();
        this.bufferSize = bufferSize;
    }

    public String getName() {
        return name;
    }

    public static MemoryHandler getLogger(String name) {
        if (loggers.get(name) != null) {
            return loggers.get(name);
        } else {
            return new MemoryHandler(name, 4);
        }
    }

    public void setLevel(Level desiredLevel) {
        level = desiredLevel;
    }

    public Level getLevel() {
        return level;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(Level.DEBUG, template, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String template, Object... args) {
        log(Level.INFO, template, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(Level.WARNING, template, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(Level.ERROR, template, args);
    }

    @Override
    public void log(Level logLevel, String message) {
        Date now = new Date();
        SimpleDateFormat nowFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String text = ("[" + logLevel + "] " + nowFormat.format(now) + " " + name + " - " + message);
        if (logs.size() < bufferSize) {
            logs.offer(text);
        } else {
            while (logs.size() > 0) {
                System.out.println(logs.poll());
            }
            logs.offer(text);
        }
    }

    @Override
    public void log(Level logLevel, String template, Object... args) {
        log(logLevel, String.format(template, args));
    }

}
