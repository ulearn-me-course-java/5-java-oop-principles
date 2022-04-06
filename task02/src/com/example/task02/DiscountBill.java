package com.example.task02;

public class DiscountBill extends Bill{
    private int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }

    public void setDiscount(int discount){
        this.discount = discount;
    }

    public long getAbsoluteDiscount(){
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice(){
        return (long)(super.getPrice() * (( 100 - (double)discount) / 100));
    }
}
