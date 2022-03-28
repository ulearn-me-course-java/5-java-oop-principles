package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final int capacity;
    private final List<String> messages;
    private final List<MessageHandler> handlers;

    public MemoryHandler(int capacity, MessageHandler... handlers) {
        this.capacity = capacity;
        messages = new ArrayList<>();
        this.handlers = Arrays.asList(handlers);
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void handle(String message) {
        messages.add(message);
        if(messages.size() >= capacity) {
            for(MessageHandler h : handlers){
                for(String s : messages)
                    h.handle(s);
            }
            messages.clear();
        }

    }
}
