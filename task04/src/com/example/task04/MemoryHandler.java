package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private MessageHandler handler;
    private long maxSize;
    private ArrayList<String> messageKeeper;

    public MemoryHandler(MessageHandler handler, long maxSize) {
        this.handler = handler;
        this.maxSize = maxSize;
    }

    @Override
    public void log(String message) {
        messageKeeper.add(message);
        if (messageKeeper.size() >= maxSize) {
            for (String mes: messageKeeper)
                handler.log(mes);
            messageKeeper.clear();
        }
    }
}
