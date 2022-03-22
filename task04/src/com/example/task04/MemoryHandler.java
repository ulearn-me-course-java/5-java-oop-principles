package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final int putPoint;
    private final List<String> messages = new ArrayList<>();
    private final List<MessageHandler> handlers;

    public MemoryHandler(int putPoint, MessageHandler... handlers) {
        this.putPoint = putPoint;
        this.handlers = Arrays.asList(handlers);
    }

    @Override
    public void log(String msg) {
        messages.add(msg);
        if (putPoint == messages.size()) {
            put();
        }
    }

    public void put() {
        handlers.forEach(handler -> messages.forEach(msg -> handler.log(msg)));
        messages.clear();
    }
}
