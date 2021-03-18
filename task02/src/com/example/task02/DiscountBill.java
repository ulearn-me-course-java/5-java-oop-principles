package com.example.task02;

public class DiscountBill extends Bill{

    private double discountPercentage;
    private long discountValue;

    public DiscountBill(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercent() {
        return discountPercentage;
    }

    public long getDiscountValue() {
        return discountValue;
    }

    public long getDiscountPrice() {
        long price = getPrice();
        discountValue = (long) (price * discountPercentage / 100);
        return price - discountValue;
    }

    public void setDiscountPercentage(double discountPercentage) throws Exception {
        if (discountPercentage < 0 || discountPercentage > 100)
            throw new Exception("Неверное значение скидки");
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n");
        sb.append("Сумма к оплате со скидкой (" + discountPercentage +"%): ").append(getDiscountPrice()).append("\n");
        sb.append("Итого скидка составила: ").append(discountValue).append("\n");
        return sb.toString();
    }

}
