package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public double getDiscount() {
        return discount * 100;
    }

    public DiscountBill(double discount) {
        this.discount = discount / 100;
    }

    public long getPrice() {
        long sum = super.getPrice();
        sum -= sum * this.discount;
        return sum;
    }

    public long getAbsDiscount(){
        return super.getPrice() - getPrice();
    }

    public String ToString(){
        return super.toString();
    }

}
