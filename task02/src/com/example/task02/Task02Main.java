package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {
        Bill bill = new Bill();
        DiscountBill dBill = new DiscountBill(0.35);
        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);//значение без скидки 250
        dBill.add(ITEM1, 10);
        dBill.add(ITEM3, 3);
        dBill.add(ITEM6, 1);
        System.out.println(dBill);//значения со скидкой 125
        System.out.println("Скидка в процентах: " + dBill.getPercentDis());
        System.out.println("Абсолютная скидка: " + dBill.getAbsDis());
        bill.add(ITEM3, 3);
        System.out.println(bill);
    }
}
