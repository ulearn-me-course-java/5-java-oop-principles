package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {

    private final long amount;

    public Milliseconds(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount;
    }

    @Override
    public long toSeconds() {
        double s = (double)amount / 1000;
        return Math.round(s);
    }

    @Override
    public long toMinutes() {
        double m = (double)amount / (1000 * 60);
        return Math.round(m);
    }

    @Override
    public long toHours() {
        double h = (double)amount / (1000 * 60 * 60);
        return Math.round(h);
    }
}
