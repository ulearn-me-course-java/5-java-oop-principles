package com.example.task02;

public class DiscountBill extends Bill {
    final int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    @Override
    public long getPrice(){
        return Math.round(super.getPrice() * (1 - discount/100f));
    }

    public String getDiscountPercent() {
        return this.discount + "%";
    }

    public long getValueOfDiscount() {
        return super.getPrice() - getPrice();
    }
}
