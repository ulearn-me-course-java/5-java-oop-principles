package com.example.task02;

public class DiscountBill extends Bill {
    int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return price - price*discount/100;
    }

    public long getDiscount() {
        return discount;
    }

    public long getAbsolutDiscount(long price) {
        return price*discount/100;
    }
}
