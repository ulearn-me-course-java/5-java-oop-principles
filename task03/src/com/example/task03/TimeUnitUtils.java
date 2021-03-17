package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в интервал в миллисекундах
     *
     * @param time интервал
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit time) {
        return new Milliseconds(time.toMillis());
    }

    /**
     * Конвертирует интервал в интервал в секундах
     *
     * @param time интервал
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit time) {
        return new Seconds(time.toSeconds());
    }

    /**
     * Конвертирует интервал  в интервал в секундах
     *
     * @param time интервал
     * @return интервал в секундах
     */
    public static Hours toHours(TimeUnit time) {
        return new Hours(time.toHours());
    }
}
