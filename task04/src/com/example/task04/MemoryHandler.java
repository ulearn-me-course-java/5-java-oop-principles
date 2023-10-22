package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private ArrayList<String> messages = new ArrayList<>();
    private MessageHandler handler;
    private int messagesLimit;
    public MemoryHandler(int messagesLimit, MessageHandler handler) {
        this.messagesLimit = messagesLimit;
        this.handler = handler;
    }
    @Override
    public void log(String message) {
        messages.add(message);
        if(messages.size() >= messagesLimit) {
            release();
        }
    }
    public void release() {
        for(String message : messages) {
            handler.log(message);
        }
        messages.clear();
    }
}
