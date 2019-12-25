package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    /**
     * Задает размер скидки в процентах
     * @param sizeDiscount
     */

    public DiscountBill(int sizeDiscount) {
        setDiscount(discount);
    }

    /**
     * Подсчитывает общую сумму покупки с учетом скидки
     *
     * @return общую стоимость покупки c учетом скидки
     */

    @Override
    public long getPrice() {
        return super.getPrice() - getAbsoluteDiscount();
    }

    /**
     * Возвращает размер скидки в процентах
     *
     * @return размер скидки в процентах
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Возвращает размер скидки в у.е.
     *
     * @return размер скидки в у.е.
     */

    public long getAbsoluteDiscount() {
        return (long) (((double) discount / 100) * super.getPrice());
    }

    /**
     * устанавливает размер скидки в процентах
     *
     * @param discount размер скидки в параметрах
     * @throws IllegalArgumentException невалидное значение скидки в процентах
     */

    public void setDiscount(int discount) throws IllegalArgumentException {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discount));
        } else {
            this.discount = discount;
        }
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += " (скидос " + discount + "%)";
        return result;
    }

}