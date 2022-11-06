package com.example.task04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private String name;
    private Levels level;
    private static List<Logger> loggers = new ArrayList<Logger>();

    private Logger(String name){
        this.name = name;
        this.level = Levels.DEBUG;
    }

    public String getName() {
       return this.name;
    }

    public static Logger getLogger(String name){
        for (Logger logger:loggers) {
            if(logger.equals(name))
                return logger;
        }
        Logger logger = new Logger(name);
        loggers.add(logger);
        return logger;
    }

    public void debug(String message){
        log(Levels.DEBUG, message);
    }
    public void debug(String format, Object... elem){  //Object... elem - любое количество дополнительных аргументов
        log(Levels.DEBUG, format, elem);
    }
    public void info(String message){
        log(Levels.INFO, message);
    }
    public void info(String format, Object... elem){
        log(Levels.INFO, format, elem);
    }

    public void warning(String message){
        log(Levels.WARNING, message);
    }
    public void warning(String format, Object... elem){
        log(Levels.WARNING, format, elem);
    }

    public void error(String message){
        log(Levels.ERROR, message);
    }
    public void error(String format, Object... elem){
        log(Levels.ERROR, format, elem);
    }
    public void log(Levels level, String message){
        if (level.ordinal() >= this.level.ordinal()) { // ordinal - возвращает значение, которое указывает позицию константы в списке констант перечисления
            System.out.println(String.format("[%s] %s %s - %s",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }
    public void log(Levels level, String format, Object... elem){
        if(level.ordinal() >= this.level.ordinal())
            System.out.println(String.format(format, elem));
    }

    public  void setLevel(Levels level){
        this.level = level;
    }

    public Levels getLevel(){
        return level;
    }
}
