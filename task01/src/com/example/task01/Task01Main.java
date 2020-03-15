package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger shit = new Logger("учеба");
        System.out.println(shit.getLevel());
        shit.log(Logger.Level.INFO,"много не спишь");
        shit.log(Logger.Level.ERROR,"ошибка учебы");
    }
}
