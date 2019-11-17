package com.example.task02;

public class DiscountBill extends Bill{
    private double discount;

    public DiscountBill(double discount) {
        if (discount > 100 || discount < 0) {
            throw new IllegalArgumentException("Error discount");
        }
        this.discount = discount;
    }

    /**
     * Метод получения размера скидки
     *
     * @return размер скидки в процентах
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Подсчитывает общую сумму покупки c учетом скидки
     *
     * @return общую стоимость покупки с учетом скидки
     */
    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price * (this.discount/100));
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
