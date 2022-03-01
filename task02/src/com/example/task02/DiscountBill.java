package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount;
    
    public DiscountBill(int discount) {
        this.discount = discount;
    }
    
    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discount / 100F));
    }
    
    public String getDiscount() {
        return discount + "%";
    }
    
    public long getAbsoluteDiscount() {
        return (long) (super.getPrice() * (discount / 100F));
    }
}
