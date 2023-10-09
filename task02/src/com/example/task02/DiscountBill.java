package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount) {
        super();

        this.discount = discount;
    }

    public double getPercentageDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
        return (long) (super.getPrice() * discount);
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        long discountPrice = (long) (price * discount);

        return price - discountPrice;
    }
}
