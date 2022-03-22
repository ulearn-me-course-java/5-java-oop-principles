package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {

    private final long amount;

    public Milliseconds(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount;
    }

    @Override
    public long toSeconds() {
        if(amount % 1000 >= 500)
            return (long) Math.ceil(amount / 1000.0);
        else
            return amount/1000;
    }

    @Override
    public long toMinutes() {

        if(this.amount / 1000.0 >= 30)
            return (long) Math.ceil(amount / (1000.0 * 60.0));
        else
            return amount / (1000 * 60);
    }

    @Override
    public long toHours() {
        if(this.amount / (1000.0 * 60.0) >= 30)
            return (long) Math.ceil(amount / (1000.0 * 60.0 * 60.0));
        else
            return amount / (1000 * 60 * 60);

    }
}
