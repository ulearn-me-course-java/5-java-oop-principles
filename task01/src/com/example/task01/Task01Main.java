package com.example.task01;

import sun.rmi.runtime.Log;

public class Task01Main {
    public static void main(String[] args) {
        Logger log = new Logger("asdf");
        Logger log1 = new Logger("af");
        Logger log2 = new Logger("asf");
        Logger log3 = Logger.getLogger("af");
        System.out.println(log3 == log1);
    }
}
