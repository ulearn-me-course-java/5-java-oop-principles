package com.example.task03;

public class Minutes implements TimeUnit {
    private final long amount;

    public Minutes(long amount) {
        // TODO: реализовать
        if (amount < 0) {
            throw new IllegalArgumentException("Amount of minutes cannot be < 0");
        }
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        // TODO: реализовать
        return amount * 60000;
    }

    @Override
    public long toSeconds() {
        // TODO: реализовать
        return amount * 60;
    }

    @Override
    public long toMinutes() {
        // TODO: реализовать
        return amount;
    }

    @Override
    public long toHours() {
        // TODO: реализовать
        return Math.round(amount / 60d);
    }
}
