package com.example.task04;

public class ConsoleHandler implements MessageHandler{
    @Override
    public void handleMessage(String message){
        System.out.println(message);
    }
    public void handleMessage(String format, Object ...objects){
        System.out.println(String.format(format, objects));
    }
}
