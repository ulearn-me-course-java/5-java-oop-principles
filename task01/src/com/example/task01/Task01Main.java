package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task01Main {
    public static void main(String[] args) {

    }
}
class Logger{

    private String name;
    private SeverityLevels level;
    private static final ArrayList<Logger> loggers = new ArrayList<>();

    public Logger(String name){
        this.name = name;
        loggers.add(this);
    }
    public void setLevel(SeverityLevels severityLevel){
        this.level = severityLevel;
    }
    public SeverityLevels getLevel(){
        return this.level;
    }

    public String getName(){
        return this.name;
    }
    public static Logger getLogger(String name){

        for (Logger log: loggers) {
            if(log.name == name)
                return log;
        }

        return new Logger(name);
    }
    public void log(SeverityLevels severityLevel, String message){

        if (this.level != null && level.compareTo(this.level) < 0) {
            return;
        }
        Date date  = new Date();
        String dateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
        System.out.printf("[%s] %s %s - %s%n", level.toString(), dateTime, name, message);

    }
    public void log(SeverityLevels severityLevel, String messageTemplate, String... messageMod){

        log(severityLevel, String.format(messageTemplate, messageMod));
    }

    public void debug(String message){
        log(SeverityLevels.DEBAG, message);
    }
    public void debug(String message, Object... messageMod){
        log(SeverityLevels.DEBAG, String.format(message, messageMod));
    }
    public void info(String message){
        log(SeverityLevels.INFO, message);
    }
    public void info(String message, Object... messageMod){
        log(SeverityLevels.INFO, String.format(message,  messageMod));
    }
    public void warning(String message){
        log(SeverityLevels.WARNING, message);
    }
    public void warning(String message, Object... messageMod){
        log(SeverityLevels.WARNING, String.format(message, messageMod));
    }
    public void error(String message){
        log(SeverityLevels.ERROR, message);
    }
    public void error(String message, Object... messageMod){
        log(SeverityLevels.ERROR, String.format(message, messageMod));
    }
    static enum SeverityLevels {
        DEBAG, INFO, WARNING, ERROR
    }

}
