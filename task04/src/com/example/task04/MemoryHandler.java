package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{

    private ConsoleHandler console= new ConsoleHandler();//предположим что будем использоваться консоль
    private ArrayList<String> messages =  new  ArrayList<String>(0);
    private int maxAmount;

    public MemoryHandler(int n){
        maxAmount = n;
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if(messages.size() >= maxAmount){
            for (String m:messages){
                console.log(m);
            }
            messages.clear();
        }
        System.out.println("wait");
    }



}
