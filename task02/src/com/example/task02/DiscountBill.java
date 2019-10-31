package com.example.task02;

/**
 * Класс DiscountBill, который расширяет класс Bill (Счет), добавляя к счету новое поле - discount (скидка).
 */
public class DiscountBill extends Bill {
    private double discount = 0;

    /**
     * Конструктор класса DiscountBill.
     * Параметр discount, передаваемый в конструктор, должен принимать действительные значения от 0 до 1.
     * Например,  discount = 0.025, означает, что к счету применяется скидка  2.5 %
     */
    public DiscountBill(double discount) {
        super();
        if (discount < 0 || discount >= 1) {
            throw new IllegalArgumentException("parameter \"discount\" must be >= 0 and < 1");
        }
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price * (this.discount));
    }

    public double getPercentDiscount() {
        return (this.discount * 100);
    }

    public double getAbsDiscount() {
        return (super.getPrice() - getPrice());
    }
}
