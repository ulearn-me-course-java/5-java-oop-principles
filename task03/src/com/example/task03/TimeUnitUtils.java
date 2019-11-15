package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в секундах | минутах | часах в интервал в миллисекундах
     *
     * @param unit интервал в секундах | минутах | часах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit unit) {
        return new Milliseconds(unit.toMillis());
    }

    /**
     * Конвертирует интервал в миллисекундах | минутах | часах в интервал в секундах
     *
     * @param unit интервал в секундах | минутах | часах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit unit) {
        return new Seconds(unit.toSeconds());
    }

    /**
     * Конвертирует интервал в миллисекундах | секундах | часах в интервал в минутах
     *
     * @param unit интервал в миллисекундах | секундах | часах
     * @return интервал в минутах
     */
    public static Minutes toMinutes(TimeUnit unit) {
        return new Minutes(unit.toMinutes());
    }

    /**
     * Конвертирует интервал в миллисекундах | секундах | минутах в интервал в часах
     *
     * @param unit интервал в миллисекундах | секундах | минутах
     * @return интервал в часах
     */
    public static Hours toHours(TimeUnit unit) {
        return new Hours(unit.toHours());
    }
}
