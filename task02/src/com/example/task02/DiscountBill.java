package com.example.task02;

public class DiscountBill extends Bill {

    private final double discount;

    public DiscountBill(double discount){
        this.discount = discount;
    }

    public double getDiscount(){
        return this.discount;
    }

    public long getAbsDiscount(){
        return super.getPrice() - this.getPrice() ;
    }

    @Override
    public long getPrice() {
        long res = super.getPrice();
        return (long) (res - res * this.discount );
    }
}
