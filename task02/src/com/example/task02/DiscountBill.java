package com.example.task02;

public class DiscountBill extends Bill {

    private final int discount; //as a percentage

    public int getDiscount() {
        return discount;
    }

    public DiscountBill(int discount) {
        super();
        this.discount = discount;
    }

    public double getAbsolutDiscount() {
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        return Math.round(super.getPrice() * (100 - discount / 100f));
    }
}
