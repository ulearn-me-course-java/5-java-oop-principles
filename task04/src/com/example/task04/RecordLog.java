package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordLog {
    private Level level;
    private String name;
    private String message;
    private Date date;
    public RecordLog(Level level, String message){
        this.level = level;
        this.message = message;
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public void setLoggerName(String name){
        this.name = name;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Level getLevel(){
        return level;
    }
    public String getName(){
        if (name == null){
            name = "No Name Logger";
        }
        return name;
    }
    public String getMessage(){
        return message;
    }
    public Date getDate(){
        return date;
    }
    public String getLogMessage(){
        if (name == null){
            name = "No Name Logger";
        }
        if (date == null) {
            date = new Date();
        }
        return "[" + level.toString() + "] " + getCurrentDate() + " " + name + " - " + message;
    }
    private String getCurrentDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY.MM.DD hh:mm:ss");
        return formatter.format(date);
    }
}
