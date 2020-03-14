package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount) {
        setDiscount(discount);
    }

    public void setDiscount(double discount) {
        if (discount > 1 || discount < 0)
            throw new IllegalArgumentException("the discount isn't correct");
        this.discount = discount;
    }

    public double getDiscount() {
        return discount * 100;
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discount));
    }

    public double getAbsoluteDiscount(Bill bill) {
        return super.getPrice() - getPrice();
        /*Общая стоимость минус общая стоимость со скидкой*/
    }


}
