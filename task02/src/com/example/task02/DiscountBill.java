package com.example.task02;

/**
 * Счет к оплате с учетом скидки
 */
public class DiscountBill extends Bill {
    private final double discount; // скидка в процентах
    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) Math.ceil(price - price * discount / 100);
    }

    @Override
    public String toString() {
        return super.toString() + "\nСкидка составила: " + getAbsoluteDiscount();
    }
}
