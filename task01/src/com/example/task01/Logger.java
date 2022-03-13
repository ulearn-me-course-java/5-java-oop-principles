package com.example.task01;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    /**
     * @serial хранит созданные логи в словаре, которые можно получить
     * с помощью
     * @see #getLogger(String)
     */
    private static Map<String, Logger> map = new HashMap<>();

    /**
     * <p>Поля хранящие информация о логе</p>
     */
    private final String name;
    private final Important important;
    private final String message;
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
    public Logger getLogger(String name){
        return map.get(name);
    }

    @Override
    public String toString() {
        return String.format("[%s] %tF %<tT %s - %s", important, date, name, message);
    }
}
