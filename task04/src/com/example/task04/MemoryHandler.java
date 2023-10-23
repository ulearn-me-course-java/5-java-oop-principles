package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{
    private ArrayList<String> messages = new ArrayList<String>();
    private final int messagesArrayMaxSize;
    public MemoryHandler(int messagesArrayMaxSize){
        this.messagesArrayMaxSize = messagesArrayMaxSize;
    }
    @Override
    public void writeMessage(String message){
        messages.add(message);
        if (messages.size()==messagesArrayMaxSize){
            for (String s : messages) {
                System.out.println(s);
            }
            messages = new ArrayList<>();
        }
    }

    public void writeMessage() {
        for (String s : messages) {
            System.out.println(s);
        }
        messages = new ArrayList<>();
    }

    public void justWrite (String message) {
        System.out.println(message);
    }
}
