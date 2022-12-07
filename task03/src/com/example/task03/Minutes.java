package com.example.task03;

public class Minutes implements TimeUnit {


    private final long amount;
    public Minutes(long amount) {
        // TODO: реализовать
        throw new UnsupportedOperationException();
    }

    @Override
    public long toMillis() {
        return toSeconds() * 1000;
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
    public long getHours() {
        return Math.round( (double)amount / 60);
    }
}
