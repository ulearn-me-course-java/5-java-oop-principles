package com.example.task03;

public class Minutes implements TimeUnit {
    private final long amount;

    public Minutes(long amount) {
        // TODO: реализовать
        this.amount = amount;
    }

    long getAmount()
    {
        return this.amount;
    }

    @Override
    public long toMillis() {
        // TODO: реализовать
        return getAmount() * 60 * 1000;
    }

    @Override
    public long toSeconds() {
        // TODO: реализовать
        return getAmount() * 60;
    }

    @Override
    public long toMinutes() {
        // TODO: реализовать
        return getAmount();
    }

    @Override
    public long toHours(){
        return Math.round((float)getAmount() / (float)60);
    }
}
