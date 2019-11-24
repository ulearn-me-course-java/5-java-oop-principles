package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {
    /**
     * Конвертирует интервал в секундах или минутах или часах в интервал в миллисекундах
     * @param unit интервал в секундах или минутах или часах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(TimeUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException();
        } else {
            return new Milliseconds(unit.toMillis());
        }
    }
    /**
     * Конвертирует интервал в миллисекундах или минутах или часах в интервал в секундах
     * @param unit интервал в миллисекундах или минутах или часах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(TimeUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException();
        } else {
            return new Seconds(unit.toSeconds());
        }
    }

    /**
     * Конвертирует интервал в миллисекундах или секундах или часах в интервал в минутах
     *
     * @param unit интервал в миллисекундах или секундах или часах
     * @return интервал в минутах
     */
    public static Minutes toMinutes(TimeUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException();
        } else {
            return new Minutes(unit.toMinutes());
        }
    }

    /**
     * Конвертирует интервал в миллисекундах или секундах или минутах в часах
     *
     * @param unit интервал в миллисекундах или секундах или минутах
     * @return интервал в часах
     */
    public static Hours toHours(TimeUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException();
        } else {
            return new Hours(unit.toHours());
        }
    }
}
