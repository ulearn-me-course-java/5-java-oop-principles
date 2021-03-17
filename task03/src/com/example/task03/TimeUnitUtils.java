package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в секундах в интервал в миллисекундах
     *
     * @param unit интервал в секундах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit unit) {
        return new Milliseconds(unit.toMillis());
    }

    /**
     * Конвертирует интервал в unit в интервал в секундах
     *
     * @param millis интервал в миллисекундах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit unit) {
        return new Seconds(unit.toSeconds());
    }

    public static Minutes toMinutes(TimeUnit unit) { return new Minutes(unit.toMinutes()); }

    public static Hours toHoures(TimeUnit unit) { return new Hours(unit.toHours()); }


}
