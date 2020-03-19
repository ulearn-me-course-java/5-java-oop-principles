package com.example.task04.handlers;

import java.util.LinkedList;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private LinkedList<String> messages = new LinkedList<>();
    private int size;

    public MemoryHandler() {
        this(1024);
    }

    public MemoryHandler(int size) {
        this.size = size;
    }

    @Override
    public void handle(String message) {
        if (messages.size() >= size) {
            messages.removeFirst();
        }

        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
