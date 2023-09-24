package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Logger {
    private Level level;

    enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR;
    }

    private String name;

    private static ArrayList<Logger> logs = new ArrayList<>();

    public static Logger getLogger(String name) {
        for (Logger logger : logs) if (logger.name == name) return logger;

        Logger l = new Logger(name);
        logs.add(l);
        return l;
    }

    public Logger(String name) {
        this.name = name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Logger) {
            Logger logger = (Logger) obj;
            return logger.name == this.name;
        }
        return false;
    }

    private String getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return (formatter.format(calendar.getTime()));
    }

    public void error(String message) {
        print(Level.ERROR, message);
    }

    public void error(String format, Object... elements) {
        print(Level.ERROR, format, elements);
    }

    public void info(String message) {
        print(Level.INFO, message);
    }

    public void info(String format, Object... elements) {
        print(Level.INFO, format, elements);
    }

    public void warning(String message) {
        print(Level.WARNING, message);
    }

    public void warning(String format, Object... elements) {
        print(Level.WARNING, format, elements);
    }

    public void debug(String message) {
        print(Level.DEBUG, message);
    }

    public void debug(String format, Object... elements) {
        print(Level.DEBUG, format, elements);
    }

    private void print(Level level, String message) {
        System.out.println(String.format("[%s] %s %s - %s", level.name(), getTime(), name, message));
    }

    private void print(Level level, String formatOfMessage, Object elements) {
        MessageFormat form = new MessageFormat(formatOfMessage);
        System.out.println(form.format(elements));
    }


}
