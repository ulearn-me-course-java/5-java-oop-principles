package com.example.task02;

public class DiscountBill extends Bill{
    double discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }
    public double getDiscount() {
        return discount * 100;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        price -= price * discount;
        return price;
    }

    public long getDifferenceWithDiscount() {
        return super.getPrice() - getPrice();
    }
}
