package com.example.task03;

public class Hours implements TimeUnit {

    private final long amount;

    public Hours(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return Math.round(amount * 60f * 60f * 1000f);
    }

    @Override
    public long toSeconds() {
        return Math.round(amount * 60f * 60f);
    }

    @Override
    public long toMinutes() {
        return Math.round(amount * 60f);
    }

    @Override
    public long getHours() {
        return amount;
    }
}
