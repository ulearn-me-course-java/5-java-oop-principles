package com.example.task04;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logger {
    private List<MessageHandler> handlers;
    private static List<Logger> loggers = new ArrayList<Logger>();
    private String name;
    private ImportanceLevel level;

    private Logger(String name, MessageHandler... handlers){
        this.name = name;
        this.handlers = Arrays.asList(handlers);
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
    public void debug(String message) throws IOException {
        log(ImportanceLevel.DEBUG, message);
    }
    public void debug(String pattern, Object... args)  {
        log(ImportanceLevel.DEBUG, pattern,args);
    }
    public void info(String message) throws IOException {
        log(ImportanceLevel.INFO, message);
    }
    public void info(String pattern, Object... args)  {
        log(ImportanceLevel.INFO, pattern,args);
    }
    public void warning(String message) throws IOException {
        log(ImportanceLevel.WARNING, message);
    }
    public void warning(String pattern, Object... args)  {
        log(ImportanceLevel.WARNING, pattern,args);
    }
    public void error(String message) throws IOException {
        log(ImportanceLevel.ERROR, message);
    }
    public void error(String pattern, Object... args)  {
        log(ImportanceLevel.ERROR, pattern,args);
    }
    public void log(ImportanceLevel level, String message) throws IOException {
        if (level.ordinal() >= this.level.ordinal()) {
            for (MessageHandler handler: handlers)
                handler.log(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }
    public void log(ImportanceLevel level, String pattern, Object... args)  {
        if(level.ordinal() >= this.level.ordinal())
            for (MessageHandler handler: handlers)
                System.out.println(MessageFormat.format(pattern, args));
    }
}
