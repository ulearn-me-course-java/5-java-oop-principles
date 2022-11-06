package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public double getDiscountedPrice() {
        long price = getPrice();
        return (double) price - (double) price * (double) discount / 100;
    }

    public double getAbsoluteDiscount() {
        return (double) getPrice() - getDiscountedPrice();
    }
}
