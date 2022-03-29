package com.example.task02;
/*
Необходимо реализовать класс DiscountBill, который должен расширять (наследовать) класс Bill,
добавляя к счету новое поле - скидка.
Итоговая стоимость должна раcчитываться как общая стоимость,
расчитанная базовым классом, за вычетом процента по скидке.
Также должен быть метод получения размера скидки (в процентах)
и абсолютного значения скидки (разница между суммой и суммой со скидкой).
 */
public class DiscountBill extends Bill {

    double discount;

    public DiscountBill(double discount){
        super();
        this.discount = discount;
    }

    //Итоговая стоимость должна раcчитываться как общая стоимость,
    //расчитанная базовым классом, за вычетом процента по скидке.
    @Override
    public long getPrice() {
        return (long) (super.getPrice() - (super.getPrice() * discount / 100));
    }

    //получение размера скидки (в процентах)
    public String getDiscount() { return discount + "%"; }

    //абсолютное значение скидки (разница между суммой и суммой со скидкой)
    public double getAbsoluteValueOfDiscount() {
        return super.getPrice() - getPrice();
    }
}
