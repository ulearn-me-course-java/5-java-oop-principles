package com.example.task03;

public class Minutes implements TimeUnit {

    private final long amount;
    public Minutes(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        // TODO: реализовать
        throw new UnsupportedOperationException();
    }

    @Override
    public long toSeconds() {
        // TODO: реализовать
        throw new UnsupportedOperationException();
    }

    @Override
    public long toMinutes() {
        return amount;
    }

    @Override
    public long toHours() {
        return this.amount / 60;
    }
}
