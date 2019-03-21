package com.example.task02;

public class DiscountBill extends Bill {
    private final double discount;

    public DiscountBill(double discount){ this.discount = discount; }

    public long getPrice(){ return (long)(super.getPrice() * (1-discount/100)); }

    public double getDiscount(){ return this.discount; }

    public double getAbsDiscount(){ return super.getPrice() - this.getPrice(); }
}

