package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger l = new Logger("log");

        Logger l1 = Logger.getLogger("log");
        Logger l2 = Logger.getLogger("log");

        System.out.println(l1 == l2);

        for(int i = 0; i <=5; i++){
            l1.debug("%d:%d", 15, 11);
        }

        for(int i =0; i < 5;i++){
            l1.debug("%d:%d", 11, 15);
            l1.error("ERROR_MSG");
        }
    }
}
