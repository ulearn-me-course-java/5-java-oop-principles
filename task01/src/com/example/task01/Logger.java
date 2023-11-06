package com.example.task01;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Logger {

    public Level LEVEL;
    public Date DATE;
    public String NAME;
    public String MESSAGE;
    public static Logger[] allLoggers;

    public Logger(String name){
        NAME = name;
    }
    public Logger(Level level, String name, String message) {
        LEVEL = level;
        NAME = name;
        DATE = new Date();
        MESSAGE = message;
    }

    public String getNAME() {
        return NAME;
    }

    public static Logger getLogger(String name){

        for(int i = 0; i < allLoggers.length; i++){
            if(allLoggers[i].NAME == name){
                return allLoggers[i];
            }
        }
        return new Logger(name);
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String str = LEVEL.toString() + DATE + NAME + MESSAGE;


        return "[" + LEVEL + "] "+ format.format(DATE) + " " + NAME + " " + MESSAGE;
    }

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public void debug(String message){
        this.MESSAGE = message;
    }

    public void debug(String)

}
