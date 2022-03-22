package com.example.task03;

public class Hours  implements TimeUnit{

    public final long amount;
    public Hours(long amount){
        this.amount = amount;
    }
    @Override
    public long toMillis() {
        return this.toSeconds() * 1000;
    }

    @Override
    public long toSeconds() {
        return this.toMinutes() * 60;
    }

    @Override
    public long toMinutes() {
        return this.amount * 60;
    }

    @Override
    public long toHours() {
        return this.amount;
    }
}
