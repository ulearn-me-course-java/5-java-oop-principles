package com.example.task02;

public class DiscountBill extends Bill {

    private int discountInPercents = 0;

    public int getDiscountInPercent(){
        return discountInPercents;
    }

    public void setDiscountsInPercent(int discount){
        discountInPercents = Math.max(0, Math.min(100, discount));
    }

    public long getAbsoluteDiscount(){
        return super.getPrice() - (super.getPrice() * ((100 - discountInPercents) / 100L));
    }

    @Override
    public long getPrice(){
        return (long)(super.getPrice() * ((100f - discountInPercents) / 100f));
    }
}
