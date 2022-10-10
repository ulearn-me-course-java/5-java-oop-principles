package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final List<MessageHandler> messages = new ArrayList<>();
    private final List<String> buffer = new ArrayList<>();
    private final int bufferSize;

    public MemoryHandler(int bufferSize, MessageHandler... messages) {
        this.bufferSize = bufferSize;
        this.messages.addAll(Arrays.asList(messages));
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
            for (String item : buffer) {
                message.log(item);
            }
        }
        buffer.clear();
    }
}
