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
        return this.toSeconds() * 1000;
    }

    @Override
    public long toSeconds() {
        // TODO: реализовать
        return this.amount * 60;
    }

    @Override
    public long toMinutes() {
        // TODO: реализовать
        return this.amount;
    }
    @Override
    public long toHours() {
        if(amount >= 30)
            return (long) Math.ceil((double)this.amount / 60.0);
        else
            return amount/60;
    }
}
