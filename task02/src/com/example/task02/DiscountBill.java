package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public double getAbsolutDiscountSum() {
        return super.getPrice() * discount / 100;
    }

    /**
     * Подсчитывает общую сумму покупки
     *
     * @return общую стоимость покупки с учётом скидки
     */
    @Override
    public long getPrice() {
        return super.getPrice() - (long)getAbsolutDiscountSum();
    }
}
