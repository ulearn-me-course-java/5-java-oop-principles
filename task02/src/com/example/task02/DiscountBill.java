package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount){
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice()* (1 - discount));
    }

    public int getPercentDis(){
        return (int)(discount * 100);
    }

    public long getAbsDis(){
        return super.getPrice() - getPrice();
    }
}
