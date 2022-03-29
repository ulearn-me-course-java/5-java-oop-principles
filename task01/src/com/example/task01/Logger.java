package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

enum Level { DEBUG, INFO, WARNING, ERROR }

public class Logger {

    private final String name;
    private Level level;
    private static final HashMap<String, Logger> loggers = new HashMap<>();

    public Logger(String name){
        this.name = name;
        loggers.put(name, this);
    }

    public String getName() { return name; }

    public static Logger getLogger(String name){
        return loggers.containsKey(name) ? loggers.get(name) : new Logger(name);
    }

    public void debug(String message){
        log(Level.DEBUG, message);
    }
    public void debug(String message, Object... args){
        debug(String.format(message, args));
    }

    public void info(String message){
        log(Level.INFO, message);
    }
    public void info(String message, Object... args){
        info(String.format(message, args));
    }

    public void warning(String message){
        log(Level.WARNING, message);
    }
    public void warning(String message, Object... args){
        warning(String.format(message, args));
    }

    public void error(String message){
        log(Level.ERROR, message);
    }
    public void error(String message, Object... args){
        error(String.format(message, args));
    }

    /*[<LEVEL>] <DATE> <TIME> <NAME> - <MESSAGE>
        LEVEL - уровень важности сообщения
        DATE - текущая дата в формате год.месяц.число (например, 2018.07.17)
        TIME - текущее время в формате часы:минуты:секунды (например, 09:56:32)
        NAME - имя логгера
        MESSAGE - текст сообщения
    */
    private void log(Level level, String message){

        //получить значение = позиции/порядковому значению - метод ordinal()
        if (level.ordinal() >= this.level.ordinal())
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                    name,
                    message));
    }
    private void log(Level level, String message, Object... args){
        log(level, String.format(message, args));
    }

    public Level getLevel() { return level; }

    public void setLevel(Level level) { this.level = level; }
}
