package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {

        DiscountBill discountBill = new DiscountBill(20);

        discountBill.add(ITEM2, 10);
        discountBill.add(ITEM5, 20);
        discountBill.add(ITEM4, 30);

        System.out.println(discountBill.getPrice());
        System.out.println(discountBill.getDiscount() + "%");
        System.out.println(discountBill.absolutDiscount());

    }
}
