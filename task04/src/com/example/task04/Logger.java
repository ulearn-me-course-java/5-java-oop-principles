package com.example.task04;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {

    private final String name;

    private MessageHandler handler;

    private Level level;

    private static ArrayList<Logger> loggers = new ArrayList<Logger>();

    private Date dateNow = new Date();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.mm.dd");
    private SimpleDateFormat formatForTimeNow = new SimpleDateFormat("hh:mm:ss");

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Logger(String name, MessageHandler handler){
        this.name = name;
        loggers.add(this);
        this.handler = handler;
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

    public void debug(String message){
        handler.toWrite(String.format("[DEBUG] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void debug(String template, Object...args){
        handler.toWrite(String.format("[DEBUG] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void info(String message){
        handler.toWrite(String.format("[INFO] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void info(String template, Object...args){
        handler.toWrite(String.format("[INFO] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void warning(String message){
        handler.toWrite(String.format("[WARNING] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void warning(String template, Object...args){
        handler.toWrite(String.format("[WARNING] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void error(String message){
        handler.toWrite(String.format("[ERROR] %s %s %s - %s", formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void error(String template, Object...args){
        handler.toWrite(String.format("[ERROR] %s %s %s - %s",  formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }

    public void log(Level level, String message){
        handler.toWrite(String.format("[%s] %s %s %s - %s", level, formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, message));
    }

    public void log(Level level, String template, Object... args){
        handler.toWrite(String.format("[%s] %s %s %s - %s", level, formatForDateNow.format(dateNow), formatForTimeNow.format(dateNow),
                name, String.format(template, args)));
    }
}
