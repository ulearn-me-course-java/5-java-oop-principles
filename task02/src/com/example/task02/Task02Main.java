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
        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);
        bill.add(ITEM3, 3);
        System.out.println(bill);
        System.out.println("\n\n");

        DiscountBill db = new DiscountBill();
        db.discount = 20;
        System.out.println("Новый чек со скидкой \n" + db.getDiscount()+"\n");
        db.add(ITEM1, 10);
        db.add(ITEM3, 3);
        db.add(ITEM6, 1);
        System.out.println(db);
        System.out.println(db.getAbsDiscount()+"\n");
        db.add(ITEM3, 3);
        System.out.println(db);
        System.out.println(db.getAbsDiscount());
    }
}
