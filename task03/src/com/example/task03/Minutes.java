package com.example.task03;

public class Minutes implements TimeUnit {
    private final long amount;

    public Minutes(long amount) {
        // TODO: реализовать
        this.amount = amount;
        //throw new UnsupportedOperationException();
    }

    @Override
    public long toMillis() {
        // TODO: реализовать
        return amount * 60 * 1000;
        //throw new UnsupportedOperationException();
    }

    @Override
    public long toSeconds() {
        // TODO: реализовать
        return this.amount * 60;
        //throw new UnsupportedOperationException();
    }

    @Override
    public long toMinutes() {
        // TODO: реализовать
        return this.amount;
        //throw new UnsupportedOperationException();
    }public long toHours() {
        return Math.round(this.amount / 60f);
    }

}