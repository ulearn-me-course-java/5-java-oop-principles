package com.example.task01;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {
    public enum Level {
        DEBUG, INFO, WARNING, ERROR
    }

    private String name;
    private Level level = Level.DEBUG;
    private PrintStream writer = System.out;
    private static Map<String, Logger> instances = new ConcurrentHashMap<>();

    public Logger(String name) {
        this.name = name;

        if (Logger.instances.containsKey(name))
            throw new IllegalArgumentException("Logger with this name has not yet been created");

        Logger.instances.put(name, this);
    }

    public static Logger getLogger(String name) {
        return instances.containsKey(name) ? instances.get(name) : new Logger(name);
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setWriter(PrintStream writer) {
        this.writer = writer;
    }

    public void log(Level level, String message) {
        if (this.level.compareTo(level) > 0) return;

        String now = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
        writer.printf("[%s] %s %s - %s", level, now, name, message);
    }

    public void log(Level level, String format, Object... args) {
        log(level, String.format(format, args));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... args) {
        log(Level.DEBUG, format, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String format, Object... args) {
        log(Level.INFO, format, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... args) {
        log(Level.WARNING, format, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String format, Object... args) {
        log(Level.ERROR, format, args);
    }
}
