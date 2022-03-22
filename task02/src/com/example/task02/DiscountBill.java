package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    /**
     * Возвращает скидку (в процентах)
     */
    public double getDiscount() {
        return discount * 100;
    }

    /**
     * Задаёт скидку
     *
     * @param discount Размер скидки в процентах (от 0 до 100)
     */
    public void setDiscount(double discount) {
        if (discount >= 0 && discount <= 100)
            this.discount = discount / 100;
        else
            throw new RuntimeException("Wrong discount");
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discount));
    }
}
