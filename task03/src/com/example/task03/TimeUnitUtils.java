package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {


    public static Milliseconds toMillis(Milliseconds value) {
        return new Milliseconds(value.toMillis());
    }
    public static Milliseconds toMillis(Seconds value) {
        return new Milliseconds(value.toMillis());
    }
    public static Milliseconds toMillis(Minutes value) {
        return new Milliseconds(value.toMillis());
    }
    public static Milliseconds toMillis(Hours value) {
        return new Milliseconds(value.toMillis());
    }
    public static Seconds toSeconds(Milliseconds value) {
        return new Seconds(value.toSeconds());
    }
    public static Seconds toSeconds(Seconds value) {
        return new Seconds(value.toSeconds());
    }
    public static Seconds toSeconds(Minutes value) {
        return new Seconds(value.toSeconds());
    }
    public static Seconds toSeconds(Hours value) {
        return new Seconds(value.toSeconds());
    }
    public static Minutes toMinutes(Milliseconds value) {
        return new Minutes(value.toMinutes());
    }
    public static Minutes toMinutes(Seconds value) {
        return new Minutes(value.toMinutes());
    }
    public static Minutes toMinutes(Minutes value) {
        return new Minutes(value.toMinutes());
    }
    public static Minutes toMinutes(Hours value) {
        return new Minutes(value.toMinutes());
    }
    public static Hours toHours(Milliseconds value) {
        return new Hours(value.toHours());
    }
    public static Hours toHours(Seconds value) {
        return new Hours(value.toHours());
    }
    public static Hours toHours(Minutes value) {
        return new Hours(value.toHours());
    }
    public static Hours toHours(Hours value) {
        return new Hours(value.toHours());
    }
}
