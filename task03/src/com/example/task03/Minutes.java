package com.example.task03;

public class Minutes implements TimeUnit {

    private final long amount;
    public Minutes(long amount) {
        // TODO: реализовать
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
    public long toHours() {
        return Math.round(amount / 60f);
    }
}
