package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {
    private long count;

    public Milliseconds(long count) {
        this.count = count;
    }

    @Override
    public long toMillis() {
        return count;
    }

    @Override
    public long toSeconds() {
        return Math.round((float)count/1000);
    }

    @Override
    public long toMinutes() {
        return Math.round((float)count/1000/60);
    }

    @Override
    public long toHours() {
        return Math.round((float)count/60/60/1000);
    }
}
