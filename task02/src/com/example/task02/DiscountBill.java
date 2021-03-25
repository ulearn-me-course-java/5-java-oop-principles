package com.example.task02;

public class DiscountBill extends Bill {
    private float discount;

    public DiscountBill(float discount) {
        this.discount = discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getDiscountValue() {
        return discount * 100;
    }

    public long getPriceWithDiscount() {
        return (long) (getPrice() * (1 - discount));
    }

    public long getDiscountedSum() {
        return (long) (getPrice() * discount);
    }

    @Override
    public String toString() {
        String bill = super.toString();
        bill += String.format(
                "\nСкидка: %.2f%% | %d\nСумма со скидкой: %d",
                getDiscountValue(),
                getDiscountedSum(),
                getPriceWithDiscount()
        );
        return bill;
    }
}