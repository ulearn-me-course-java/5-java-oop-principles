package com.example.task02;

public class DiscountBill extends Bill {
    private float discount;

    public DiscountBill(float discount){
        this.discount = discount;
    }

    public long getDiscountPrice() {
        return (long) (getPrice() * (1f - discount));
    }

    public long getDiscountedSum() {
        return (getPrice() - getDiscountPrice());
    }

    public float getDiscountPercent() {
        return discount * 100;
    }

    public float getDiscount(){
        return discount;
    }
}
