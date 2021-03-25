package com.example.task01;

public class Task01Main {
    public static void main(String[] args) throws Exception {
        Logger l1 = new Logger("Y", Level.WARNING);
        Logger l2 = Logger.getLogger("Y");

        if (l1.equals(l2)) {
            System.out.println("WW");
        }
        else { System.out.println("GG"); }
    }
}
