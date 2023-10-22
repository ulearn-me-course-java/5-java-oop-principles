package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {

    private final String name;
    private Level level;
    private static ArrayList<Logger> loggers = new ArrayList<>();

    private Logger(String name) {
        this.name = name;

        setLevel(Level.WARNING);

        loggers.add(this);
    }

    public static Logger getLogger(String name) {
        for (Logger logger : loggers) {
            if (logger.name == name) {
                return logger;
            }
        }
        return new Logger(name);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel(){
        return level;
    }

    public void info(String message){
        log(Level.INFO, message);
    }

    public void info(String format, Object... elements) {
        log(Level.INFO, String.format(format, elements));
    }

    public void warning(String message){
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... elements) {
        log(Level.WARNING, String.format(format, elements));
    }

    public void debug(String message){
        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... elements) {
        log(Level.DEBUG, String.format(format, elements));
    }

    public void error(String message){
        log(Level.ERROR, message);
    }

    public void error(String format, Object... elements) {
        log(Level.ERROR, String.format(format, elements));
    }


    private void log(Level level, String message) {
        if(level.ordinal() >= this.level.ordinal()) {
            System.out.println(String.format("[%s] %s %s - %s",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    name,
                    message));
        }
    }
}
