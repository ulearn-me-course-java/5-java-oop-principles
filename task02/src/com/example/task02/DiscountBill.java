package com.example.task02;

public class DiscountBill extends Bill{

    private final int discount;

    public DiscountBill(int discount) {
        super();
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return Math.round(super.getPrice() * (1 - discount/100f));
    }

    public String getDiscount(){
        return "Cкидка составила" + discount + "%";
    }

    public long getAbsDiscount(){
        return super.getPrice() - getPrice();
    }
}
