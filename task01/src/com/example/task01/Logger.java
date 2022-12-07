package com.example.task01;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;

public class Logger {

    public final String name;
    private Level level;
    //public final String date;
    private final Date date;
    //public final String time;
    private static HashMap<String, Logger> logs = new HashMap<String, Logger>();

    public Logger(String name){
        this.name = name;
        ZonedDateTime dateTime = ZonedDateTime.now();
        date = new Date();
        logs.put(name, this);
        //date = "" + dateTime.getYear() + "." + dateTime.getMonthValue() + "." + dateTime.getDayOfMonth();
        //time = "" + dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSecond();
    }

    public static Logger getLogger(String name){
        return logs.containsKey(name) ? logs.get(name) : new Logger(name);
    }

    private void showLogMessage(Level level, String message){
        if(level.ordinal() >= this.level.ordinal()){
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date), name, message));

        }
    }

    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void log(Level level, String message){
        showLogMessage(level, message);
    }
    public void  log(Level level, String message, Object... params){
        log(level, String.format(message, params));
    }

    public void debug(String message){
        showLogMessage(Level.DEBUG, message);
    }
    public void debug(String message, Object... params){
        debug(String.format(message, params));
    }

    public void info(String message){
        showLogMessage(Level.INFO, message);
    }
    public void info(String message, Object... params){
        debug(String.format(message, params));
    }

    public void warning(String message){
        showLogMessage(Level.WARNING, message);
    }
    public void warning(String message, Object... params){
        debug(String.format(message, params));
    }

    public void error(String message){
        showLogMessage(Level.ERROR, message);
    }
    public void error(String message, Object... params){
        debug(String.format(message, params));
    }
}
enum Level{
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

