package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {
        DiscountBill discount = new DiscountBill(25);
        discount.add(ITEM2, 5);

        System.out.println(discount.getPrice());
        System.out.println(discount.getDiscountPercent());
        System.out.println(discount.getValueOfDiscount());
    }
}
