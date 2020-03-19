package com.example.task03;

 public class Hours implements TimeUnit {
    private long amount;
    public Hours(long amount) {
        this.amount=amount;

    }

    @Override
    public long toMillis() {
        return amount*36000;

    }

    @Override
    public long toSeconds() {
        return amount*360;
    }

    @Override
    public long toMinutes() {
        return amount*60;
    }
    @Override
    public long toHours(){
        return amount;
    }
}
