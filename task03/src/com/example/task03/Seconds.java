package com.example.task03;

/**
 * Интервал в секундах
 */
public class Seconds implements TimeUnit {

    private final long amount;

    public Seconds(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount * 1000;
    }

    @Override
    public long toSeconds() {
        return amount;
    }

    @Override
    public long toMinutes() {
        if(this.amount >= 30)
            return (long) Math.ceil(amount / 60.0);
        else
            return this.amount / 60;
    }

    @Override
    public long toHours() {
        if(this.amount / 60.0 >= 30)
            return (long) Math.ceil(this.amount / (60.0 * 60.0));
        else
            return this.amount / (60 * 60);
    }
}
