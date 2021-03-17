package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler handler;
    private final long bufferSize;
    private final ArrayList<String> messages;

    public MemoryHandler(MessageHandler handler, long bufferSize) {
        this.handler = handler;
        this.bufferSize = bufferSize;
        messages = new ArrayList<>();
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() >= bufferSize) {
            for (String elem : messages)
                handler.log(elem);
            messages.clear();
        }
    }
}
