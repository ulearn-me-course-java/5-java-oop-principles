package com.example.task03;

/**
 * Интервал в минутах
 */
public class Minutes implements TimeUnit {

    private final long amount;

    public Minutes(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("the amount of minutes can't be < 0");
        }
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount * 60000;
    }

    @Override
    public long toSeconds() {
        return amount * 60;
    }

    @Override
    public long toMinutes() {
        return amount;
    }

    @Override
    public long toHours() {
        return Math.round(amount / 60d);
    }
}
