package com.example.task03;

public class Hours implements TimeUnit {
    private final long amount;

    public Hours(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount of hours cannot be < 0");
        }
        this.amount = amount;
    }

    @Override
    public long toHours() {
        return amount;
    }

    @Override
    public long toMinutes() {
        return amount * 60;
    }

    @Override
    public long toSeconds() {
        return amount * 3600;
    }

    @Override
    public long toMillis() {
        return amount * 3600000;
    }
}
