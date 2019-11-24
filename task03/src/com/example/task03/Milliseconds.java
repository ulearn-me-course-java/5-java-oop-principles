package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {

    private final long amount;

    public Milliseconds(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount of milliseconds cannot be < 0");
        }
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return this.amount;
    }

    @Override
    public long toSeconds() {
        return Math.round(this.amount / 1000d);
    }

    @Override
    public long toMinutes() {
        return Math.round(this.amount / 60000d);
    }

    @Override
    public long toHours() {
        return Math.round(this.amount / 3600000d);
    }
}
