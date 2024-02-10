package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public int getDiscount() {
        return (int) (discount * 100);
    }
    public void setDiscount(double discount){
        this.discount = discount;
    }

    @Override
    public long getPrice(){
        return super.getPrice() - getAbsDiscount();
    }
    public long getAbsDiscount(){
        return (long) (super.getPrice() * discount);
    }
}
