package com.example.task02;

public class DiscountBill extends Bill {
    private double discount = 0;

    public DiscountBill(double discount) {
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("Discount must be between 0 and 1");
        }
        this.discount = discount;
    }
    /**
     * Метод получения размера скидки
     *
     * @return размер скидки
     */
    public double getDiscount() {
        return discount * 100;
    }
    /**
     * Подсчитывает общую сумму покупки c учетом скидки
     *
     * @return общую стоимость покупки с учетом скидки
     */
    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price * (this.discount));
    }
    /**
     * Подсчитывает разницу между суммой и суммой со скидкой
     *
     * @return разницу между суммой и суммой со скидкой
     */
    public double getAbsoluteDiscount() {
        return super.getPrice() - this.getPrice();
    }
}
