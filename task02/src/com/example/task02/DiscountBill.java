package com.example.task02;

public class DiscountBill extends Bill {
    final double discount; //в процентах

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    public long getPrice() {
        return (long) (super.getPrice() * (1L - discount * 0.01));
    }

    public double getDiscount() {
        return discount * 100;
    }

    public double getAbsPrice() {
        return super.getPrice() - this.getPrice();
    }
}
