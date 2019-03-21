package com.example.task02;

public final class DiscountBill extends Bill {
    private int disc;
    private long oldPrice;
    private long newPrice;

    public DiscountBill(int disc) {
        check(disc);
        this.disc = disc;
    }

    public void setDisc(int disc) {
        check(disc);
        this.disc = disc;
    }

    @Override
    public long getPrice() {
        oldPrice = super.getPrice();
        newPrice = oldPrice - (oldPrice * disc) / 100;
        return newPrice;
    }

    /**
     * Разница между суммой и суммой со скидкой.
     */
    public long absDiscount() {
        return oldPrice - newPrice;
    }

    private void check(int disc) {
        if (disc > 100 || disc <= 0) {
            throw new IllegalArgumentException();
        }
    }
}