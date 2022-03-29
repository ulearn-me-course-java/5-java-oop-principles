package com.example.task04;

import java.util.ArrayList;
import java.util.Collection;

public class MemoryHandler implements MessageHandler {
    private ArrayList<String> cache = new ArrayList<>();
    private final int limit;
    private final MessageHandler sink;
    @Override
    public void addMessage(String message) {
        cache.add(message);
        if (cache.size() > limit) sink();
    }
    public void sink() {
        for (String msg : cache) sink.addMessage(msg);
        cache = new ArrayList<>();
    }

    public MemoryHandler(int limit, MessageHandler sink) {
        this.limit = limit;
        this.sink = sink;
    }
}
