package com.example.task02;

public class DiscountBill extends Bill {

    private double sale;

    public DiscountBill(double sale) {
        if (sale >= 0 && sale <= 100) {
            this.sale = sale;
        }
    }

    //Также должен быть метод получения размера скидки (в процентах), возврат скидки.
    public double getSale(){
    return this.sale;
    }

    // возврат абсолютного значения скидки (разница между суммой и суммой со скидкой)
    public double getAbsolute(){
        return super.getPrice() - this.getTotalPrice();
    }

    //Итоговая стоимость должна расчитываться как общая стоимость,
    //расчитанная базовым классом, за вычетом процента по скидке
    public double getTotalPrice(){
        return super.getPrice() *(1 - sale / 100);
    }

}
