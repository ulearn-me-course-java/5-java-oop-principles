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
        return this.amount*60*1000;
    }

    @Override
    public long toSeconds() {
        // TODO: реализовать
        return this.amount * 60;
    }

    @Override
    public long toMinutes() {
        // TODO: реализовать
        return amount;
    }

    @Override
    public long toHours(){
        return Math.round(this.amount/60f);
    }
}
