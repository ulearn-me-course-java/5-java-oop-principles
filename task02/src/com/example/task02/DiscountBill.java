package com.example.task02;

public class DiscountBill extends Bill {
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    private double discount;

    public double getDiscount() {
        return discount * 100.;
    }

    public DiscountBill(double discount) {
        this.discount = discount / 100.;
    }

    @Override
    public long getPrice() {
        long sum = super.getPrice();
        sum -= sum * this.discount;
        return sum;
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}