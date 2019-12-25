package com.example.task02;

/**
 * Счет к оплате c учётом скидки
 */
public class DiscountBill extends Bill {

    /**
     * Скидка в процентах
     */
    private int discount = 0;

    public DiscountBill(int discount) {
        if (discount < 0 || discount >= 100) {
            throw new IllegalArgumentException("Invalid discount.");
        }
        this.discount = discount;
    }

    /**
     * Возвращает процент скидки
     */
    public int getDiscountPercent() {
        return discount;
    }

    /**
     * Возвращает размер скидки в валюте
     */
    public long getDiscountValue() {
        return super.getPrice() - this.getPrice();
    }

    /**
     * Устанавливает размер скидки в процентах
     */
    public void setDiscount(int discount) {
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            throw new AssertionError("Invalid discount.");
        }
    }

    @Override
    public long getPrice() {
        long discountPrice = super.getPrice();
        discountPrice *= (100 - discount);
        return discountPrice / 100;
    }

    @Override
    public String toString() {
        if (discount == 0) {
            return super.toString();
        } else {
            return super.toString() + " (с учётом скидки " + discount + "%)";
        }
    }
}