package com.example.task02;

public class DiscountBill extends Bill{
    private double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public long  getAbsoluteDiscount() {
        return  super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() - super.getPrice() * (discount / 100));
    }
}
