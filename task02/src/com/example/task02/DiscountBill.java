package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount){
        this.setDiscount(discount);
    }

    public void setDiscount(double discount) {
        if(discount >= 0 || discount <= 100){
            this.discount = discount;
        }
    }

    public double getDiscount() {
        return discount;
    }
    public double absoluteDiscount() {
        return super.getPrice() - this.getPrice();
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() * (1 - discount));
    }
}