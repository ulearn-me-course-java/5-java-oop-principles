package com.example.task03;

/**
 * Интервал в часах
 */
public class Hours implements TimeUnit {

    private final long amount;

    public Hours(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount of hours cannot be < 0");
        }
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return this.amount * 3600000;
    }

    @Override
    public long toSeconds() {
        return this.amount * 3600;
    }

    @Override
    public long toMinutes() {
        return this.amount * 60;
    }

    @Override
    public long toHours() {
        return this.amount;
    }
}
