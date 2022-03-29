package com.example.task04;

import sun.rmi.runtime.Log;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Logger {

    private final String name;
    private Level lvl;
    private final Date date;
    private static final HashMap<String, Logger> map = new HashMap<>();

    public Logger(String name) {
        this.name = name;
        date = new Date();
        map.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return new Logger(name);
    }

    public void debug(String message) {
        System.out.println(message);
    }
    public void debug(String message, Object... args) {
        debug(String.format(message, args));
    }

    public void info(String message) {
        System.out.println(message);
    }
    public void info(String message, Object... args) {
        info(String.format(message, args));
    }

    public void warning(String message) {
        System.out.println(message);
    }
    public void warning(String message, Object... args) {
        warning(String.format(message, args));
    }

    public void error(String message) {
        System.out.println(message);
    }
    public void error(String message, Object... args) {
        error(String.format(message, args));
    }

    public void log(Level lvl, String message) {
        System.out.println(lvl + " " + message);
    }
    public void log(Level lvl, String message, Object... args) {
        log(lvl, String.format(message, args));
    }

    public void setLevel(Level lvl) {
        this.lvl = lvl;
    }
    public Level getLevel() {
        return lvl;
    }

    public void showLogMessage(Level lvl, String message) {
        if (lvl.ordinal() >= this.lvl.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    lvl, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date), name, message));
        }
    }
}