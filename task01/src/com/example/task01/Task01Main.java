package com.example.task01;



public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("ddd");
        Logger logger1 = Logger.getLogger("ddd");
        Logger logger2 = Logger.getLogger("ddd");
        System.out.println(logger1 ==logger2);
    }


}
