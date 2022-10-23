package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static List<Logger> loggers = new ArrayList<Logger>();
    private String name;
    private ImportanceLevel level;

    private Logger(String name){
        this.name = name;
        level = ImportanceLevel.DEBUG;
    }
    public ImportanceLevel getLevel(){
        return level;
    }
    public void setLevel(ImportanceLevel level) {
        this.level = level;
    }
    public String getName(){
        return name;
    }
    public static Logger getLogger(String name){

        for (Logger logger:loggers) {
            if (logger.name.equals(name))
                return logger;
        }

       Logger logger = new Logger(name);
       loggers.add(logger);
       return logger;

    }
    public void debug(String message) {
        log(ImportanceLevel.DEBUG, message);
    }
    public void debug(String pattern, Object... args)  {
        log(ImportanceLevel.DEBUG, pattern,args);
    }
    public void info(String message)  {
        log(ImportanceLevel.INFO, message);
    }
    public void info(String pattern, Object... args)  {
        log(ImportanceLevel.INFO, pattern,args);
    }
    public void warning(String message) {
        log(ImportanceLevel.WARNING, message);
    }
    public void warning(String pattern, Object... args)  {
        log(ImportanceLevel.WARNING, pattern,args);
    }
    public void error(String message) {
        log(ImportanceLevel.ERROR, message);
    }
    public void error(String pattern, Object... args)  {
        log(ImportanceLevel.ERROR, pattern,args);
    }
    public void log(ImportanceLevel level, String message)  {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }
    public void log(ImportanceLevel level, String pattern, Object... args)  {
        if(level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format(pattern, args));
    }
}
