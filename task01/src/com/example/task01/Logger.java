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
        log(Level.ERROR, message);
    }

    public void error(String format, Object... elements) {
        log(Level.ERROR, format, elements);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String format, Object... elements) {
        log(Level.INFO, format, elements);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... elements) {
        log(Level.WARNING, format, elements);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... elements) {
        log(Level.DEBUG, format, elements);
    }

    private void log(Level level, String message) {
        if(this.level.ordinal() <= level.ordinal() ) {
            System.out.println(String.format("[%s] %s %s - %s", level.name(), getTime(), name, message));
        }

    }

    private void log(Level level, String formatOfMessage, Object elements) {
        if(this.level.ordinal() <= level.ordinal() ) {
            MessageFormat form = new MessageFormat(formatOfMessage);
            System.out.println(form.format(elements));
        }
    }
}
