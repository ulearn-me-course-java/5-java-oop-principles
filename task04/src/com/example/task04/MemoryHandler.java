package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final int maxSize;
    private final List<String> messages = new ArrayList<>();
    private final List<MessageHandler> handlers;

    public MemoryHandler(int maxSize, MessageHandler... handlers) {
        this.maxSize = maxSize;
        this.handlers = Arrays.asList(handlers);
    }

    @Override
    public void log(String msg) {
        messages.add(msg);
        if (maxSize >= messages.size()) {
            append();
        }
    }

    public void append() {
        for (MessageHandler handler : handlers) {
            for (String message : messages)
                handler.log(message);
            messages.clear();
        }
    }
}
