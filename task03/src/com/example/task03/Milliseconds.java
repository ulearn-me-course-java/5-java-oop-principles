package com.example.task03;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

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
        return Math.round(amount / 1000d);
    }

    @Override
    public long toMinutes() { return Math.round(amount / 60000d); }

    @Override
    public long toHours() {
        return amount / 3600000;
    }
}
