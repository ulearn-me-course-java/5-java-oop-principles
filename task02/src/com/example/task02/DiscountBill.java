package com.example.task02;

import java.security.PublicKey;

public class DiscountBill extends Bill {
    private double Discount;
    public DiscountBill(double discount){
        Discount = discount;
    }
    @Override
    public long getPrice() {
        long basePrice = super.getPrice();
        return (long)(basePrice * Discount);
    }

    public long toPercent(){
        return (long)(Discount * 100);
    }

    public long getAbsoluteValue(){
        long basePrice = super.getPrice();
        long discPrice = (long)(basePrice * Discount);
        return basePrice - discPrice;
    }


}
