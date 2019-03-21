package com.example.task01;

import jdk.nashorn.internal.ir.Expression;

import java.util.*;
import java.text.*;

enum SeverityLevels {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private static ArrayList<Logger> loggers = new ArrayList<>();
    private String name;
    private SeverityLevels lvl;

    public Logger(String name) {
        this.name = name;
        loggers.add(this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        for (Logger log : loggers) {
            if (log.getName() == name)
                return log;
        }
        throw new IllegalArgumentException();
    }

    void log(SeverityLevels lvl, String mess) {
        log(lvl, mess, null);
    }

    void log(SeverityLevels lvl, String mess, Object... objects) {
        SimpleDateFormat formatDate =
                new SimpleDateFormat("yyyy.mm.dd hh:mm:ss");
        //[<LEVEL>] <DATE> <TIME> <NAME> - <MESSAGE>
        if (this.lvl.compareTo(lvl) <= 0)
            System.out.println("[" + lvl + "] " + formatDate.format(new Date()) + " "
                    + name + " - " + String.format(mess, objects));
    }

    void setLevel(SeverityLevels lvl) {
        this.lvl = lvl;
    }

    SeverityLevels getLevel() {
        return lvl;
    }

    public void error(String mess) {
        log(lvl, mess, null);
    }

    public void error(String mess, Object... objects) {
        log(lvl, mess, objects);
    }

    public void warning(String mess) {
        log(lvl, mess, null);
    }

    public void warning(String mess, Object... objects) {
        log(lvl, mess, objects);
    }

    public void info(String mess) {
        log(lvl, mess, null);
    }

    public void info(String mess, Object... objects) {
        log(lvl, mess, objects);
    }

    public void debug(String mess) {
        log(lvl, mess, null);
    }

    public void debug(String mess, Object... objects) {
        log(lvl, mess, objects);
    }
}
