package com.example.task02;

import com.sun.javafx.binding.StringFormatter;

import java.text.MessageFormat;

public class DiscountBill extends Bill {
    private int discount;

    public DiscountBill(int discount) {
        this.setDiscount(discount);
    }

    public void setDiscount(int discount) {
        if (discount > 100 || discount < 0)
            throw new IllegalArgumentException("Недопустимая скидка");
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public long getPrice() {
        return (long) (super.getPrice() * (1 - (double) discount / 100));
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - this.getPrice();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("Without discount: ");
        builder.append(super.getPrice()).append(" with discount: ").append(this.getPrice());
        return builder.toString();
    }
}
