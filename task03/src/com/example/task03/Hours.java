package com.example.task03;

public class Hours implements TimeUnit {

    private final long amount;

    public Hours(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return Math.round((double)amount * 60 * 60 * 1000);
    }

    @Override
    public long toSeconds() {
        return Math.round((double)amount * 60 * 60);
    }

    @Override
    public long toMinutes() {
        return Math.round((double)amount * 60);
    }

    @Override
    public long toHours() {
        return amount;
    }
}
