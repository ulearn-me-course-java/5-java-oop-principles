package com.example.task01;

import com.sun.javafx.binding.StringFormatter;

import javax.sound.sampled.Line;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Logger {
    Logger (String name) {
        this.name = name;

        if (scroll.isEmpty() || !scroll.containsKey(name)) { scroll.put(name,this); }
    }
    Logger (String name, Level lvl) {
        level = lvl;
        this.name = name;

        if (scroll.isEmpty() || !scroll.containsKey(name)) { scroll.put(name,this); }
    }

    private final String name;

    private Level level;

    private static final Map<String,Logger> scroll = new HashMap<>();

    public String getName() { return name; }
    public Level getLevel() { return level; }
    public static Logger getLogger(String name) throws Exception {
        if (loggerInBool(name)) {
            return scroll.get(name);
        }
        else { throw new Exception(); }
    }

    private void getMessage(Level lvl, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                    name,
                    message));
        }
    }

    public void setLevel(Level lvl) { level = lvl; }

    private static boolean loggerInBool(String name) {
        return scroll.containsKey(name);
    }

    public void debug(String message) {
        log(Level.DEBUG,message);
    }
    public void debug(String message, Objects... params) {
        debug(String.format(message,params));
    }

    public void info(String message) {
        log(Level.INFO,message);
    }
    public void info(String message, Objects... params) {
        info(String.format(message,params));
    }

    public void warning(String message) {
        log(Level.DEBUG,message);
    }
    public void warning(String message, Objects... params) {
        warning(String.format(message,params));
    }

    public void error(String message) {
        log(Level.DEBUG,message);
    }
    public void error(String message, Objects... params) {
        error(String.format(message,params));
    }

    public void log(Level lvl, String message) {
        getMessage(lvl,message);
    }
    public void log(Level lvl, String message, Object... params) {
        getMessage(lvl,String.format(message,params));
    }
}
