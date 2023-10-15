package com.example.task02;

public class DiscountBill extends Bill {
    private final double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public long getPrice() {
        long price = super.getPrice();
        price -= price * discount / 100;
        return price;
    }

    public long getDifference(){
        return super.getPrice() - getPrice();
    }
}
