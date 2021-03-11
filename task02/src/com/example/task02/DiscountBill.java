package com.example.task02;

public class DiscountBill extends Bill {

    private final double discount;//В процентах Число от 0 до 100 иначе NaN

    public DiscountBill(double discount) {
        if (discount < 0 || discount > 100) this.discount = Double.NaN;
        else this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountedPrice() {
        return getPrice() * (1 - discount / 100);
    }

    public double getAbsolutePrice() {
        return getPrice() - getDiscountedPrice();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        int index = stringBuilder.indexOf("Сумма к оплате: ");
        stringBuilder.delete(index,stringBuilder.length());
        stringBuilder.append("Сумма к оплате с учетом скидки: "+getDiscountedPrice());
        return stringBuilder.toString();
    }
}
