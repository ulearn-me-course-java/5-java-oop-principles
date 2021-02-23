package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в интервал в миллисекундах
     *
     * @param timeUnit - интервал
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit timeUnit) {
        return new Milliseconds(timeUnit.toMillis());
    }

    /**
     * Конвертирует интервал в интервал в секундах
     *
     * @param timeUnit - интервал
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit timeUnit) { return new Seconds(timeUnit.toSeconds()); }

    /**
     * Конвертирует интервал в интервал в минутах
     *
     * @param timeUnit - интервал
     * @return интервал в минутах
     */
    public static Minutes toMinutes(TimeUnit timeUnit) { return new Minutes(timeUnit.toMinutes()); }

    /**
     * Конвертирует интервал в интервал в часах
     *
     * @param timeUnit - интервал
     * @return интервал в часах
     */
    public static Hours toHours(TimeUnit timeUnit) { return new Hours(timeUnit.toHours()); }
}
