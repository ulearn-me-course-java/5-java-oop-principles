package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() - super.getPrice() * discount/100);
    }

    public long absoluteValue() {
        return super.getPrice() - getPrice();
    }
}
