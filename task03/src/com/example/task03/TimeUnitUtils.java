package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует временной интервал в интервал в миллисекундах
     *
     * @param time временной интервал
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit time) {
        return new Milliseconds(time.toMillis());
    }

    /**
     * Конвертирует временной интервал в интервал в секундах
     *
     * @param time временной интервал
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit time) {
        return new Seconds(time.toSeconds());
    }

    /**
     * Конвертирует временной интервал в интервал в минутах
     *
     * @param time временной интервал
     * @return интервал в минутах
     */
    public static Minutes toMinutes(TimeUnit time) {
        return new Minutes(time.toMinutes());
    }

    /**
     * Конвертирует временной интервал в интервал в часах
     *
     * @param time временной интервал
     * @return интервал в часах
     */
    public static Hours toHours(TimeUnit time) {
        return new Hours(time.toHours());
    }
}
