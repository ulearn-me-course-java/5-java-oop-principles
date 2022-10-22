package com.example.task03;

public class Minutes implements TimeUnit {

    private final long amount;
    public Minutes(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public long toMillis() {
        return getAmount() * 60000;
    }

    @Override
    public long toSeconds() {
        return getAmount() * 60;
    }

    @Override
    public long toMinutes() {
        return getAmount();
    }

    @Override
    public long getHours() {
        return toHours();
    }

    public long toHours() {
        return Math.round(this.amount / 60f);
    }
}
