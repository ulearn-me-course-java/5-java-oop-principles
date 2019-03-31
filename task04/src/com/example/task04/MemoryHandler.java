package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler{

    private long capacity;
    private List<String> memory = new ArrayList<>();
    private final MessageHandler handler;

    public MemoryHandler(long capacity, MessageHandler handler){
        this.capacity = capacity;
        this.handler = handler;
    }

    @Override
    public void printMessage(String message) {
        memory.add(message);
        if (memory.size() >= capacity){
            for (String mess: memory) {
                handler.printMessage(mess);
            }
            memory.clear();
        }
    }
}
