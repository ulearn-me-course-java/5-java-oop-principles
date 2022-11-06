package com.example.task02;

public class DiscountBill extends Bill{
    public double discount;

    public DiscountBill(double discount){
        this.discount = discount;
    }
    public double getDiscount(){return discount;}
    @Override
    public long getPrice(){
        long price = super.getPrice();
        return (long)(price - ((price*discount)/100));
    }

    public long absoluteDiscount(){
        long price = super.getPrice();
        long discountedPrice = getPrice();
        return price - discountedPrice;
    }

}
