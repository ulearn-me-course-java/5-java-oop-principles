package com.example.task02;

public class DiscountBill extends Bill{
    private int discount;

    public DiscountBill(int percent){
        this.discount = percent;
    }

    @Override
    public long getPrice(){
        return super.getPrice() * (1 - discount / 100);
    }

    public long differenceAboutPrices(){
        return super.getPrice() - super.getPrice() * (1 - discount / 100);
    }

    public int getDiscount(){
        return discount;
    }

    public void setDiscount(int discount){
        this.discount = discount;
    }
}
