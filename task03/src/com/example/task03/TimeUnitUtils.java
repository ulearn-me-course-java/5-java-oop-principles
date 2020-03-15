package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в секундах в интервал в миллисекундах
     *
     * @param amount интервал в любом времени
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit amount) {
        return new Milliseconds(amount.toMillis());
    }

    /**
     * Конвертирует интервал в миллисекундах в интервал в секундах
     *
     * @param amount интервал в любом времени
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit amount) {
        return new Seconds(amount.toSeconds());
    }

    /**
     * Конвертирует интервал в часах в интервал в минутах
     *
     * @param amount интервал в любом виде времени
     * @return интервал в минутах
     */
    public static Minutes toMinutes(TimeUnit amount) {
        return new Minutes(amount.toMinutes());
    }

    /**
     * Конвертирует интервал в часах в интервал в минутах
     *
     * @param amount интервал в любом виде времени
     * @return интервал в часах
     */
    public static Hours toHours(TimeUnit amount) {
        return new Hours(amount.toHours());
    }
}
