package com.example.task02;

public class DiscountBill extends Bill{
    private final double discount;
    public DiscountBill(int discount){
        this.discount=discount;
    }
    @Override
    public long getPrice(){
        return (long) Math.ceil(super.getPrice()*(1- discount/100));
    }
    public String getDiscountPercentages(){
        return discount + "%";
    }
    public double getDiscountAbsolute(){
        return super.getPrice() - getPrice();
    }
}
