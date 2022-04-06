package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    public String getDiscount() {
        return discount + "%";
    }

    @Override
    public long getPrice() {
        return super.getPrice() * (100 - discount) / 100;
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
}
