package com.example.task03;

/**
 * Интервал в секундах
 */
public class Seconds implements TimeUnit {
    private long count;

    public Seconds(long count) {
        this.count = count;
    }

    @Override
    public long toMillis() {
        return count*1000;
    }

    @Override
    public long toSeconds() {
        return count;
    }

    @Override
    public long toMinutes() {
        return Math.round((float)count/60);
    }

    @Override
    public long toHours() {
        return Math.round((float)count/60/60);
    }
}
