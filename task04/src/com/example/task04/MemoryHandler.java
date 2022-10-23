package com.example.task04;

import java.util.*;

public class MemoryHandler implements MessageHandler {
    private final List<MessageHandler> messages = new ArrayList<>();
    private final List<String> buffer = new ArrayList<>();
    private final int bufferSize;

    public MemoryHandler(int bufferSize, MessageHandler... handlers) {
        this.bufferSize = bufferSize;
        messages.addAll(Arrays.asList(handlers));
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() >= bufferSize) {
            logBuffer();
        }
    }

    public void logBuffer() {
        for (MessageHandler message : messages) {
            for (String msg : buffer) {
                message.log(msg);
            }
        }
        buffer.clear();
    }
}
