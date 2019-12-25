package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует TimeUnit интервал в интервал в миллисекундах
     *
     * @param unit интервал TimeUnit
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit unit) {
        return new Milliseconds(unit.toMillis());
    }

    /**
     * Конвертирует TimeUnit интервал в интервал в секундах
     *
     * @param unit интервал TimeUnit
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit unit) {
        return new Seconds(unit.toSeconds());
    }

    /**
     * Конвертирует TimeUnit интервал в интервал в минутах
     *
     * @param unit интервал TimeUnit
     * @return интервал в минутах
     */
    public static Minutes toMinutes(TimeUnit unit) {
        return new Minutes(unit.toMinutes());
    }

    /**
     * Конвертирует TimeUnit интервал в интервал в часах
     *
     * @param unit интервал TimeUnit
     * @return интервал в часах
     */
    public static Hours toHours(TimeUnit unit) {
        return new Hours(unit.toHours());
    }
}