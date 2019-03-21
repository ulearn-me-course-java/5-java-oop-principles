package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils{
    public static Milliseconds toMillis(Seconds seconds) {
        return new Milliseconds(seconds.toMillis());
    }
    public static Milliseconds toMillis(Minutes mins) {
        return new Milliseconds(mins.toMillis());
    }
    public static Milliseconds toMillis(Hours hours) {
        return new Milliseconds(hours.toMillis());
    }

    public static Seconds toSeconds(Milliseconds millis) {
        return new Seconds(millis.toSeconds());
    }
    public static Seconds toSeconds(Minutes mins) { return new Seconds(mins.toSeconds()); }
    public static Seconds toSeconds(Hours hrs) { return new Seconds(hrs.toSeconds()); }

    public static Minutes toMinutes(Milliseconds ms) { return new Minutes(ms.toMinutes()); }
    public static Minutes toMinutes(Seconds s) { return new Minutes(s.toMinutes()); }
    public static Minutes toMinutes(Hours h) { return new Minutes(h.toMinutes()); }

    public static Hours toHours(Milliseconds ms) { return new Hours(ms.getHours()); }
    public static Hours toHours(Seconds s) { return new Hours(s.getHours()); }
    public static Hours toHours(Minutes m) { return new Hours(m.getHours()); }

}