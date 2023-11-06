package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.MessageFormat;

public class Logger {
    private static final ArrayList<Logger> logs = new ArrayList<>();
    private final String name;
    private Level level=Level.INFO;

    public Logger(String name) {
        this.name = name;
        logs.add(this);
    }

    public static Logger getLogger(String name) {
        for (Logger logger : logs)
            if (logger.name.equals(name)) return logger;
        return new Logger(name);
    }

    private String getNowTime() {
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

    public void log(Level level, String message) {
        printMessage(level, message);
    }

    public void log(Level level, String template, Object... args) {
        printMessage(level, template, args);
    }

    private void printMessage(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal())
            System.out.printf("[%s] %s %s - %s%n", level.name(), getNowTime(), name, message);
    }

    private void printMessage(Level level, String formatOfMessage, Object elements) {
        if (level.ordinal() >= this.level.ordinal()) {
            MessageFormat form = new MessageFormat(formatOfMessage);
            System.out.printf("[%s]", level.name());
            System.out.println(form.format(elements));
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Logger) {
            Logger logger = (Logger) obj;
            return logger.name.equals(this.name);
        }
        return false;
    }
}
