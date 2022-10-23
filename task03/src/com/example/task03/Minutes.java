package com.example.task03;

public class Minutes implements TimeUnit {

    private final long amount;

    public Minutes(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return Math.round(amount * 60 * 1000);
    }

    @Override
    public long toSeconds() {
        return Math.round(amount * 60);
    }

    @Override
    public long toMinutes() {
        return amount;
    }

    @Override
    public long getHours() {
        return Math.round(amount / 60f);
    }
}
