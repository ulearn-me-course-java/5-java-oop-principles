package com.example.task02;

public class DiscountBill extends Bill{
    private int discountInPercent;
    private long discountInAbsoluteValue;

    public DiscountBill(int discountInPercent) {
        this.discountInPercent = discountInPercent;
    }

    public int getDiscountInPercent() {
        return discountInPercent;
    }

    public void setDiscountInPercent(int discountInPercent) {
        if (discountInPercent < 0 || discountInPercent > 100) {
            System.out.println("Discount value is incorrect");
        }
        else {
            this.discountInPercent = discountInPercent;
        }
    }

    public long getDiscountInAbsoluteValue() {
        return discountInAbsoluteValue;
    }

    public long getPriceWithDiscount() {
        long currentPrice = getPrice();
        discountInAbsoluteValue = currentPrice * discountInPercent / 100;
        return currentPrice - discountInAbsoluteValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n");
        sb.append("Ваша скидка составила : ").append(discountInAbsoluteValue).append("\n");
        sb.append("Сумма без скидки : ").append(getPrice()).append("\n");
        sb.append("Сумма со скидкой : ").append(getPriceWithDiscount()).append("\n");
        return sb.toString();
    }
}
