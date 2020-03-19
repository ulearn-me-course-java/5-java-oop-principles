package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(int discount) {
        setDiscount(discount);
    }

    public int getDiscount() {
        return (int) (discount * 100);
    }

    public long getAbsoluteDiscount() {
        return (long) (super.getPrice() * discount);
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount should be in range of 0..100");
        }

        this.discount = discount / 100d;
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discount));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('\n')
                .append("Сумма без скидки: ").append(super.getPrice()).append('\n')
                .append("Скидка: ").append(getDiscount()).append("% (").append(getAbsoluteDiscount()).append(")").append('\n');

        return sb.toString();
    }
}
