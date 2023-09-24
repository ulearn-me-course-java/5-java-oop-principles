package com.example.task02;

public class DiscountBill extends Bill {

    private int discount = 0;

    public DiscountBill(int discount) {
        if (discount <= 100 && discount >= 0) {
            this.discount = discount;
        } else {
            this.discount = 0;
        }
        ;
    }

    public int getDiscountInPercent() {
        return discount;
    }

    public long totalDiscount() {
        return getPrice() * discount / 100;
    }


}
