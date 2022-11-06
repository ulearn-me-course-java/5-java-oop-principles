package com.example.task01;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
public class Logger {
    public enum LoggerLevel {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    private LoggerLevel level;
    private final String loggerName;
    static ArrayList<Logger> loggers = new ArrayList<Logger>();
    public Logger(String name){
        loggerName = name;
        level = LoggerLevel.INFO;
    }
    public String getName() {
        return loggerName;
    }

    public static Logger getLogger(String name) {
        for (Logger logger : loggers) {
            if (logger.getName() == name) {
                return logger;
            }
        }
        loggers.add(new Logger(name));
        return loggers.get(loggers.size() - 1);
    }

    public void setLevel(LoggerLevel level) {
        this.level = level;
    }

    public LoggerLevel getLevel() {
        return level;
    }

    public void debug(String message){
        printLogger(LoggerLevel.DEBUG, message);
    }

    public void debug(String format, Object... args)
    {
        printLogger(LoggerLevel.DEBUG, format, args);
    }

    public void info(String message){
        log(LoggerLevel.INFO, message);
    }

    public void info(String format, Object... args)
    {
        log(LoggerLevel.INFO, format, args);
    }

    public void warning(String message){
        log(LoggerLevel.WARNING, message);
    }

    public void warning(String format, Object... args)
    {
        log(LoggerLevel.WARNING, format, args);
    }
    public void error(String message){
        log(LoggerLevel.ERROR, message);
    }

    public void error(String format, Object... args)
    {
        log(LoggerLevel.ERROR, format, args);
    }
    public void log(LoggerLevel level, String message){
       printLogger(level, message);
    }
    public void log(LoggerLevel level, String format, Object... args) {

        printLogger(level, format, args);

    }
    private void printLogger(LoggerLevel level, String message){
        if (level.ordinal() >= this.level.ordinal()){
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String strDate = sdf.format(cal.getTime());
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, strDate, this.loggerName, message));
        }
    }

    private void printLogger(LoggerLevel level, String format, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(format, args));
        }

    }

}

