package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils
{
    /**
     * Конвертирует интервал в интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit interval)
    {
        return new Milliseconds(interval.toMillis());
    }

    /**
     * Конвертирует интервал в интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit interval)
    {
        return new Seconds(interval.toSeconds());
    }

    /**
     * Конвертирует интервал в интервал в минутах
     */
    public static Minutes toMinutes(TimeUnit interval)
    {
        return new Minutes(interval.toMinutes());
    }

    /**
     * Конвертирует интервал в интервал в часах
     */
    public static Hours toHours(TimeUnit interval)
    {
        return new Hours(interval.toHours());
    }
}
