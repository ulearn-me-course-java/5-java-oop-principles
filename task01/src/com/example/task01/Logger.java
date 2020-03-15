package com.example.task01;

import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {
    String name;
    Levels level;
    private static ArrayList<Logger> loggers = new ArrayList<Logger>();
    private Date dateNow = new Date();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.mm.dd");
    private SimpleDateFormat formatForTimeNow = new SimpleDateFormat("hh:mm:ss");

    public Logger(String name) {
        this.name = name;
        loggers.add(this);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public Levels getLevel() {
        return level;
    }


    public static Logger getLogger(String name) {
        int ind = 0;
        for (Logger logs : loggers) {
            if (logs.name == name) {
                ind = loggers.indexOf(logs);
            }
        }
        return loggers.get(ind);
    }


    public void debug(String message) {
        System.out.println(String.format("[DEBUG] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void debug(String template, Object... args) {
        System.out.println(String.format("[DEBUG] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void info(String message) {
        System.out.println(String.format("[INFO] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void info(String template, Object... args) {
        System.out.println(String.format("[INFO] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void warning(String message) {
        System.out.println(String.format("[WARNING] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void warning(String template, Object... args) {
        System.out.println(String.format("[WARNING] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void error(String message) {
        System.out.println(String.format("[ERROR] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void error(String template, Object... args) {
        System.out.println(String.format("[DEBUG] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void log(Levels levels, String message) {
        System.out.println(String.format("[%s] %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void log(Levels levels, String template, Object... args) {
        System.out.println(String.format("[%s] %s %s - %s", level, formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }


}
