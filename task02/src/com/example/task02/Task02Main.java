package com.example.task02;

public class Task02Main {
    private static final Item ITEM1 = new Item("Товар 1", 10);

    public static void main(String[] args) {
        DiscountBill discBill = new DiscountBill(30);
        discBill.add(ITEM1, 1);
        System.out.println(discBill);

        System.out.println("Скидка: " + discBill.getDiscount());
        System.out.println("Абсолютная разница: " + discBill.getAbsoluteDiscountValue());
    }
}
