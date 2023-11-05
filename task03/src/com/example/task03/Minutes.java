package com.example.task03;

public class Minutes implements TimeUnit
{
    private final long amount;
    public Minutes(long amount)
    {
        this.amount = amount;
    }

    @Override
    public long toMillis()
    {
        Seconds s = new Seconds(toSeconds());
        return s.toMillis();
    }

    @Override
    public long toSeconds()
    {
        return amount * 60;
    }

    @Override
    public long toMinutes()
    {

        return amount;
    }

    @Override
    public long toHours()
    {
        return Math.round((double)amount / 60);
    }
}
