package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует произвольный интервал в интервал в миллисекундах
     *
     * @param interval произвольный интервал
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(Seconds interval) { return new Milliseconds(interval.toMillis()); }
    public static Milliseconds toMillis(Minutes interval) {
        return new Milliseconds(interval.toMillis());
    }
    public static Milliseconds toMillis(Hours interval) {
        return new Milliseconds(interval.toMillis());
    }

    /**
     * Конвертирует произвольный интервал в интервал в секундах
     *
     * @param interval произвольный интервал
     * @return интервал в секундах
     */
    public static Seconds toSeconds(Milliseconds interval) {
        return new Seconds(interval.toSeconds());
    }
    public static Seconds toSeconds(Minutes interval) {
        return new Seconds(interval.toSeconds());
    }
    public static Seconds toSeconds(Hours interval) {
        return new Seconds(interval.toSeconds());
    }

    /**
     * Конвертирует произвольный интервал в интервал в минутах
     *
     * @param interval произвольный интервал
     * @return интервал в минутах
     */
    public static Minutes toMinutes(Milliseconds interval) {
        return new Minutes(interval.toMinutes());
    }
    public static Minutes toMinutes(Minutes interval) {
        return new Minutes(interval.toMinutes());
    }
    public static Minutes toMinutes(Hours interval) {
        return new Minutes(interval.toMinutes());
    }

    /**
     * Конвертирует произвольный интервал в интервал в часах
     *
     * @param interval произвольный интервал
     * @return интервал в часах
     */
    public static Hours toHours(Milliseconds interval) {
        return new Hours(interval.toHours());
    }
    public static Hours toHours(Minutes interval) {
        return new Hours(interval.toHours());
    }
    public static Hours toHours(Hours interval) {
        return new Hours(interval.toHours());
    }

}
