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
        double sec = (double)amount / 1000;
        return Math.round(sec);
    }

    @Override
    public long toMinutes() {
        double min = (double)amount / (1000 * 60);
        return Math.round(min);
    }

    @Override
    public long getHours(){
        double hour = (double)amount / (1000 * 60 * 60);
        return Math.round(hour);
    }
}
