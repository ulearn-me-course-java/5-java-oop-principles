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
        return  Math.round((double)milliseconds / 1000);
    }

    @Override
    public long toMinutes() {
        return Math.round((double)milliseconds / (1000 * 60));
    }

    @Override
    public long toHours() {
        return Math.round((double)milliseconds / (1000 * 60 * 60));
    }
}
