package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler handler;
    private final long maxSize;
    private ArrayList<String> buffer;

    public MemoryHandler(MessageHandler handler, long maxSize) {
        this.handler = handler;
        this.maxSize = maxSize;
        buffer = new ArrayList<>();
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() >= maxSize) {
            for (String msg : buffer)
                handler.log(msg);
            buffer.clear();
        }
    }
}