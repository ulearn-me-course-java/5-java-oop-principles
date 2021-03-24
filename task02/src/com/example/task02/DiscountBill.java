package com.example.task02;

import java.text.MessageFormat;

public class DiscountBill extends Bill {
    private int discount;

    public DiscountBill(int discount){
        this.setDiscount(discount);
    }

    public void setDiscount(int discount){
        if(discount > 100 || discount < 0)
            throw new IllegalArgumentException("discount must be between 0% and 100%");
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }

    @Override
    public long getPrice(){
        return (long)(super.getPrice() * (1 - (double)discount/100));
    }

    public long getAbsoluteDiscount(){
        return super.getPrice() - this.getPrice();
    }
}