package com.example.task02;

public class DiscountBill extends Bill{
    private final int sale = 10;
    public int getSale(){ return sale; }

    @Override
    public long getPrice() { return (long)(super.getPrice() * (1 - (float)sale / 100)); }
    public long difference(){ return super.getPrice() - getPrice(); }

    @Override
    public String toString() {
        return super.toString() + "\nSale was: " + difference();
    }
}
