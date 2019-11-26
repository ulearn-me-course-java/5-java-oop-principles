package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Переводит объект любого класса, реализующего интерфейс TimeUnit в Миллисекунды
     *
     * @param unit Объект класса, реализующего интерфейс TimeUnit
     * @return Объект класса Milliseconds
     */
    public static Milliseconds toMillis(TimeUnit unit) {
        return new Milliseconds(unit.toMillis());
    }

    /**
     * Переводит объект любого класса, реализующего интерфейс TimeUnit в Секунды
     *
     * @param unit Объект класса, реализующего интерфейс TimeUnit
     * @return Объект класса Seconds
     */
    public static Seconds toSeconds(TimeUnit unit) {
        return new Seconds(unit.toSeconds());
    }

    /**
     * Переводит объект любого класса, реализующего интерфейс TimeUnit в Минуты
     *
     * @param unit Объект класса, реализующего интерфейс TimeUnit
     * @return Объект класса Minutes
     */
    public static Minutes toMinutes(TimeUnit unit) {
        return new Minutes(unit.toMinutes());
    }

    /**
     * Переводит объект любого класса, реализующего интерфейс TimeUnit в Часы
     *
     * @param unit Объект класса, реализующего интерфейс Hours
     * @return Объект класса Milliseconds
     */
    public static Hours toHours(TimeUnit unit) {
        return new Hours(unit.toHours());
    }
}
