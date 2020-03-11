package com.example.task01;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.ArrayList;

public class Logger {
    private String name;

    private Level level;

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    private static ArrayList<Logger> loggers = new ArrayList<Logger>();

    private Date dateNow = new Date();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.mm.dd");
    private SimpleDateFormat formatForTimeNow = new SimpleDateFormat("hh:mm:ss");

    public void debug(String message){
        System.out.println(String.format("[DEBUG] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void debug(String template, Object...args){
        System.out.println(String.format("[DEBUG] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void info(String message){
        System.out.println(String.format("[INFO] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void info(String template, Object...args){
        System.out.println(String.format("[INFO] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void warning(String message){
        System.out.println(String.format("[WARNING] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void warning(String template, Object...args){
        System.out.println(String.format("[WARNING] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void error(String message){
        System.out.println(String.format("[ERROR] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void error(String template, Object...args){
        System.out.println(String.format("[ERROR] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void log(Level level, String message){
        System.out.println(String.format("[%s] %s %s %s - %s", level, formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void log(Level level, String template, Object... args){
        System.out.println(String.format("[%s] %s %s %s - %s", level, formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public Logger(String name){
        this.name = name;
        loggers.add(this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name){
        int ind = 0;
        for(Logger lg: loggers){
            if(lg.name == name) {
                ind = loggers.indexOf(lg);
            }
        }
        return loggers.get(ind);
    }
}
