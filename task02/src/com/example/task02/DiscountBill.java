package com.example.task02;

public class DiscountBill extends Bill {

    private final double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountAmount() {
        return super.getPrice() * discount / 100;
    }

    @Override
    public long getPrice() {
        return Math.round(super.getPrice() * (100 - discount) / 100.0);
    }
}