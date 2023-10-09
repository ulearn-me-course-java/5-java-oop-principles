package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private ArrayList<String> messages = new ArrayList<String>();
    private final int messagesArrayMaxSize;

    public MemoryHandler(int messagesArrayMaxSize) {
        this.messagesArrayMaxSize = messagesArrayMaxSize;
    }

    @Override
    public void write(String message) {
        messages.add(message);
        if (messages.size() == messagesArrayMaxSize) {
            for (String str : messages) {
                System.out.println(str);
            }
        }
    }
}