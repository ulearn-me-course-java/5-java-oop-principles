package com.example.task02;

import java.text.MessageFormat;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {
        DiscountBill disBill = new DiscountBill(10);
        disBill.add(ITEM1, 10);
        disBill.add(ITEM3, 3);
        disBill.add(ITEM6, 1);
        System.out.println(disBill);
        disBill.add(ITEM3, 3);
        System.out.println(disBill);
        System.out.println(disBill.getPrice());
        System.out.println(MessageFormat.format("Процент {0}%", disBill.getDiscount()));
        System.out.println(MessageFormat.format("Абсолютное значение скидки {0}",disBill.getAbsoluteDiscount()));

    }
}
