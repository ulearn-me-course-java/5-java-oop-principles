package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public Date date;
    public String message;
    public Level level;
    public String className;

    public Log(String className, Date date, String message, Level level) {
        this.className = className;
        this.date = date;
        this.message = message;
        this.level = level;
    }

    @Override
    public String toString(){
        String dateTime = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(date);
        return String.format("[%s] %s %s - %s\n", level, dateTime, className, message);
    }
}
