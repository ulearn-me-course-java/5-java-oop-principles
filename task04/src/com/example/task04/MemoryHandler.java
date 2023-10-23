package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler handler;
    private final long maxSize;
    private final ArrayList<String> messageKeeper;

    public MemoryHandler(MessageHandler handler, long maxSize) {
        this.handler = handler;
        this.maxSize = maxSize;
        messageKeeper = new ArrayList<>();
    }

    public MemoryHandler(MessageHandler handler) {
        this(handler, 1);
    }

    @Override
    public void log(String message) {
        messageKeeper.add(message);
        if (messageKeeper.size() >= maxSize) {
            for (String mes : messageKeeper)
                handler.log(mes);
            messageKeeper.clear();
        }
    }
}
