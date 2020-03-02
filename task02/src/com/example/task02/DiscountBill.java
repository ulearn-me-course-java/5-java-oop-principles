package com.example.task02;

public class DiscountBill extends Bill {
    private short discount;

    public DiscountBill(short discount) {
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        }
    }

    public short getDiscount(){
        return discount;
    }

    public long getAbsolute() {
        return super.getPrice() - this.getPrice();
    }

    @Override
    public long getPrice(){
        return super.getPrice() *(1 - discount / 100);
    }


}
//Необходимо реализовать класс `DiscountBill`, который должен расширять (наследовать) класс `Bill`, добавляя к счету новое
//поле - скидка. Итоговая стоимость должна расчитываться как общая стоимость, расчитанная базовым классом, за вычетом процента по скидке.
//Также должен быть метод получения размера скидки (в процентах) и абсолютного значения скидки (разница между суммой и суммой со скидкой).