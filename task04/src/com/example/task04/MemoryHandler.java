package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private final MessageHandler handler;

    private final int limit;

    private ArrayList<String> messages;

    public MemoryHandler(MessageHandler handler, int limit){
        this.handler = handler;
        this.limit = limit;
        messages = new ArrayList<String>();
    }

    public void toEmpty(){
        for (String msg : messages) {
            handler.toWrite(msg);
        }
        messages.clear();
    }

    @Override
    public void toWrite(String message) {
        messages.add(message);
        if(messages.size() == limit){
            toEmpty();
        }
    }
}
