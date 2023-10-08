package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {

    private final long milliseconds;

    public Milliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public long toMillis() {
        return milliseconds;
    }

    @Override
    public long toSeconds() {
        return Math.round(milliseconds / 1000f);
    }

    @Override
    public long toMinutes() {
        return Math.round(milliseconds / 1000 / 60f);
    }

    @Override
    public long toHours() {
        return this.milliseconds / 3600 / 1000 ;
    }
}
