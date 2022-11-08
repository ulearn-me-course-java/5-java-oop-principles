package com.example.task04;
import java.util.List;
import java.util.ArrayList;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Logger {
    public enum LogLevel {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }


    static ArrayList<Logger> loggers = new ArrayList<Logger>();
    private final List<MessageHandler> loggerList = new ArrayList<>();

    private final String Name;
    private LogLevel Level;

    public Logger(String name){
        Name = name;
        Level = LogLevel.INFO;
        loggers.add(this);

    }


    public String getName(){

        return Name;

    }
    public Logger(String name, MessageHandler... handlers) {
        Name = name;
        Level = LogLevel.INFO;
        loggerList.addAll(Arrays.asList(handlers));
    }
    public void setLevel (LogLevel level){
        Level = level;

    }
    public LogLevel getLevel(){
        return Level;

    }


    public static Logger getLogger(String name){
        for (Logger logger : loggers)
        {
            if (logger.Name == name) {
                return logger;
            }
            else System.out.println("Экземпляра с таким именем не существует");

        }

        return null;
    }
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    public void info(String format, Object... elems)
    {
        log(LogLevel.INFO, format, elems);
    }
    public void error(String message)
    {
        log(LogLevel.ERROR, message);
    }
    public void error(String format, Object... elems)
    {
        log(LogLevel.ERROR, format, elems);
    }
    public void debug(String message)
    {
        log(LogLevel.DEBUG, message);
    }
    public void debug(String format, Object... elems)
    {
        log(LogLevel.DEBUG, format, elems);
    }
    public void warning(String message)
    {
        log(LogLevel.WARNING, message);
    }
    public void warning(String format, Object... elems)
    {
        log(LogLevel.WARNING, format, elems);
    }
    public void log(LogLevel level, String message){
        printMessage(level, message);
    }
    public void log(LogLevel level, String format, Object... elems){
        printMessage(level, format, elems);
    }
    private void printMessage(LogLevel level, String message) {
        if (level.ordinal() >= this.Level.ordinal()) {
            String logMessage = MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.Name,
                    message);
            for (MessageHandler mh : loggerList){
                mh.log(logMessage);
            }
        }
    }
    private void printMessage(LogLevel level, String format, Object... elems) {
        if (level.ordinal() >= this.Level.ordinal() ) {
            String logMessage = MessageFormat.format(format, elems);
            for (MessageHandler mh : loggerList){
                mh.log(logMessage);
            }
        }
    }

}
