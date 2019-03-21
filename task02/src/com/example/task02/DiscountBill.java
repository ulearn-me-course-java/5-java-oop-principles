package com.example.task02;

public class DiscountBill extends Bill {

    long discount;

    @Override
    public long getPrice() {
        return super.getPrice() - super.getPrice() * discount / 100;
    }

    public String getDiscount() {
        return String.format("Текущая скидка: %d %%", discount);
    }

    public String getAbsDiscount() {
        return String.format("Скидка составила: %d", super.getPrice() - getPrice());
    }
}
