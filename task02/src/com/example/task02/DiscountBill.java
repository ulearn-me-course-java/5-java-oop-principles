package com.example.task02;

public class DiscountBill extends Bill {
    private final int percentDiscount;

    public DiscountBill(int discount){
        this.percentDiscount = discount;
    }

    @Override
    public long getPrice() {
        return (long) Math.ceil(super.getPrice() * (1 - (double)percentDiscount / 100));
    }

    public String getDiscountPercentages(){
        return percentDiscount + "%";
    }

    public double getAbsoluteDiscount(){
        return super.getPrice() - getPrice();
    }
}
