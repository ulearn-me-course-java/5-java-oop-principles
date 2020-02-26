package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler handler;
    private final long capacity;
    private ArrayList<String> buffer;

    public MemoryHandler(MessageHandler handler, long capacity){
        this.capacity = capacity;
        this.handler = handler;
        buffer = new ArrayList<>();
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if(buffer.size() >= capacity)
            handle();
    }

    public void handle(){
        for (String message :
                buffer) {
            handler.log(message);
        }
        buffer.clear();
    }
}
