package com.example.task03;

/**
 * Интервал в секундах
 */
public class Seconds implements TimeUnit {

    private final long amount;

    public Seconds(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount * 1000;
    }

    @Override
    public long toSeconds() {
        return amount;
    }

    @Override
    public long toMinutes() {
        double m = (double)amount/60;
        return Math.round(m);
    }

    @Override
    public long toHours() {
        double h = (double)amount / (60 * 60);
        return Math.round(h);
    }
}
