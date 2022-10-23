package com.example.task04.handlers;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private MessageHandler proxy;
    private List<String> messages = new ArrayList<>();
    private int size;

    public MemoryHandler(MessageHandler proxyHandler) {
        this(proxyHandler, 1024);
    }

    public MemoryHandler(MessageHandler proxyHandler, int size) {
        proxy = proxyHandler;
        this.size = size;
    }

    @Override
    public void handle(String message) {
        if (messages.size() >= size) {
            messages.forEach(proxy::handle);
            messages.clear();
        }

        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
