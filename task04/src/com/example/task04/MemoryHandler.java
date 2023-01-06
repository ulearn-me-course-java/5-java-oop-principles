package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final List<MessageHandler> handlers = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();
    private final int bufferSize;

    public MemoryHandler(int bufferSize, MessageHandler... handlers) {
        this.bufferSize = bufferSize;
        this.handlers.addAll(Arrays.asList(handlers));
    }

    public MemoryHandler(MessageHandler... handlers){
        this(42, handlers);
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() >= bufferSize) {
            logBuffer();
        }
    }

    public void logBuffer() {
        for (MessageHandler handler : handlers) {
            for (String message : messages) {
                handler.log(message);
            }
        }
        messages.clear();
    }
}
