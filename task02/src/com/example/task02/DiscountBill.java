package com.example.task02;

public class DiscountBill extends Bill{
    private final double discount;

    public DiscountBill(double discount){
        this.discount = discount / 100.;
    }

    public double getDiscount() {
        return this.discount;
    }

    @Override
    public long getPrice(){
        return (long)(super.getPrice() * (1 - getDiscount()));
    }

    @Override
    public String toString(){
        return super.toString();
    }

    public long getAbsoluteDifference(){
        return super.getPrice() - getPrice();
    }

}
