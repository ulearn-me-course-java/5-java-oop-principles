package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в секундах в интервал в миллисекундах
     *
     * @param seconds интервал в секундах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(Seconds seconds) {return new Milliseconds(seconds.toMillis());}

    /**
     * Конвертирует интервал в миллисекундах в интервал в секундах
     *
     * @param millis интервал в миллисекундах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(Milliseconds millis) {
        return new Seconds(millis.toSeconds());
    }

    /**
     * Conversion between minutes and seconds
     */
    //From minutes to seconds
    public static Seconds toSeconds(Minutes minutes) {
        return new Seconds(minutes.toSeconds());
    }
    //From seconds to minutes
    public static Minutes toMinutes(Seconds seconds) {
        return new Minutes(seconds.toMinutes());
    }

    /**
     * Conversion between milliseconds and minutes
     */
    //From millisecondes to minutes
    public static Minutes toMinutes(Milliseconds millis) {
        return new Minutes(millis.toMinutes());
    }
    //From minutes to millisecondes
    public static Milliseconds toMillis(Minutes minutes) {
        return new Milliseconds(minutes.toMillis());
    }

    /**
     * Conversion between milliseconds and hours
     */
    //From milliseconds to hours
    public static Hours toHours(Milliseconds millis) { return new Hours(millis.toHours());}
    //From hours to milliseconds
    public static Milliseconds toMillis(Hours hours) {return new Milliseconds(hours.toMillis());}

    /**
     * Conversion between seconds and hours
     */
    //From hours to seconds
    public static Seconds toSeconds(Hours hours){ return new Seconds(hours.toSeconds());};
    //From seconds to hours
    public static Hours toHours(Seconds seconds){ return new Hours(seconds.toHours());}

    /**
     * Conversion between minutes and hours
     */
    //From hours to minutes
    public static Minutes toMinutes(Hours hours){return new Minutes(hours.toMinutes());}
    //From minutes to hours
    public static Hours toHours(Minutes minutes){return  new Hours(minutes.toHours());}
}

