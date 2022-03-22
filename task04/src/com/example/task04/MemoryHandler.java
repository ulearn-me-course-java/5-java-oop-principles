package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler{
    private final int flushPoint;
    private final List<String> messages = new ArrayList<>();
    private final List<MessageHandler> handlers;

    public MemoryHandler(int flushPoint, MessageHandler... handlers) {
        this.flushPoint = flushPoint;
        this.handlers = Arrays.asList(handlers);
    }

    @Override
    public void log(String msg) {
        messages.add(msg);
        if (flushPoint == messages.size()) {
            flush();
        }
    }

    public void flush() {
        handlers.forEach(handler -> messages.forEach(handler::log));
        messages.clear();
    }
}
