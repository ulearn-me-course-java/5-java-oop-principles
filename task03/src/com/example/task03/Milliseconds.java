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
        if(amount%1000>=500)
            return amount / 1000+1;
        else return amount / 1000;
    }

    @Override
    public long toMinutes() {
        if(amount/1000>=30)
            return amount / (1000 * 60)+1;
        else return amount / (1000*60);
    }

    @Override
    public long toHours() {
        return Math.round(amount / 3600/1000);
    }
}
