package com.example.task02;

public class DiscountBill extends Bill {
    private float discount = 0.1f;

    @Override
    public long getPrice() {
        long startPrice = super.getPrice();
        return Math.round(startPrice * (1.0f - discount));
    }

    public long absDiscount(){
        long startPrice = super.getPrice();
        return startPrice - getPrice();
    }

    public String getDiscount(){
        return String.format("%.2f", discount * 100) + "%";
    }
}
