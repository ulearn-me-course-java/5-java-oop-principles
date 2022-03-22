package com.example.task01;

import java.util.*;
import java.util.stream.Collectors;

public class Logger {
    /**
     * @serial хранит созданные логи в словаре, которые можно получить
     * с помощью
     * @see #getLogger(String)
     */
    private static final Map<String, Logger> map = new HashMap<>();

    /**
     * <p>Поля хранящие информация о логе, их геттеры</p>
     */
    private final String name;
    public String getName() { return name; }
    private final Important important;
    private String message;
    private final Date date;

    /**
     * <p>Конструктор, принимающий информацию о логе. Сохраняет информацию и
     * текущую дату</p>
     * @param name Имя лога
     * @param important Важность
     * @param message Сообщение
     */
    public Logger(String name, Important important, String message){
        this.name = name;
        this.important = important;
        this.message = message;
        date = new Date();
        map.put(name, this);
    }

    /**
     * <p>Получает лог по его имени</p>
     * @param name
     * @return Лог, который имеет имя name
     */
    public static Logger getLogger(String name){
        return map.get(name);
    }

    @Override
    public String toString() {
        return String.format("[%s] %tF %<tT %s - %s", important, date, name, message);
    }

    /*
    @Override
    public String toString() {
        return String.format("[%s] %s %s - %s", important, date.toLocaleString(), name, message);
    }
     */

    private static Important importantFilter = Important.values()[0];
    public static void setLevel(Important imp){ importantFilter = imp; }
    public static Important getLevel() { return importantFilter; }
    public static List<String> getLogs(){
        return map.entrySet().stream().filter(x -> x.getValue().important.ordinal() > importantFilter.ordinal())
                .map(x -> x.getValue().toString()).collect(Collectors.toList());
    }


    /**
     * <p>Методы для задания<p/>
     */
    public static void debug(String message){
        map.entrySet().stream().filter(x -> x.getValue().important.compareTo(Important.DEBUG) == 0)
                .forEach(x -> x.getValue().message = message);
    }
    public static void debug(String message, Object... args){
        debug(String.format(message, args));
    }

    public static void info(String message){
        map.entrySet().stream().filter(x -> x.getValue().important.compareTo(Important.INFO) == 0)
                .forEach(x -> x.getValue().message = message);
    }
    public static void info(String message, Object... args){
        info(String.format(message, args));
    }

    public static void warning(String message){
        map.entrySet().stream().filter(x -> x.getValue().important.compareTo(Important.WARNING) == 0)
                .forEach(x -> x.getValue().message = message);
    }
    public static void warning(String message, Object... args){
        warning(String.format(message, args));
    }

    public static void error(String message){
        map.entrySet().stream().filter(x -> x.getValue().important.compareTo(Important.ERROR) == 0)
                .forEach(x -> x.getValue().message = message);
    }
    public static void error(String message, Object... args){
        error(String.format(message, args));
    }

    /**
     * <p>Еще что-то</p>
     */
    public static void log(Important imp, String message){
        map.entrySet().stream().filter(x -> x.getValue().important.compareTo(imp) == 0)
                .forEach(x -> x.getValue().message = message);
    }
    public static void log(Important imp, String message, Object... args){
        log(imp, String.format(message, args));
    }

}
