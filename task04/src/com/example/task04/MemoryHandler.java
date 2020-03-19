package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler handler;
    private final long maxSize;
    private ArrayList<String> bf;

    public MemoryHandler(MessageHandler handler, long maxSize) {
        this.handler = handler;
        this.maxSize = maxSize;
        bf = new ArrayList<>();;
    }

    @Override
    public void log(String message) {
        bf.add(message);
        if (bf.size() >= maxSize) {
            for (String msg : bf)
                handler.log(msg);
            bf.clear();
        }
    }
}
