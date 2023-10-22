package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{

    private int count;
    private MessageHandler handler;
    private ArrayList<String> messages = new ArrayList<>();

    public MemoryHandler(int count, MessageHandler handler) {
        this.count = count;
        this.handler = handler;
    }

    @Override
    public void log(String message) {
        messages.add(message);

        if(messages.size() >= count) {
            for(String msg : messages) {
                handler.log(msg);
            }
        }
    }
}
