package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler implements MessageHandler {
    private final ArrayList<MessageHandler> messages = new ArrayList<>();
    private final ArrayList<String> buffer = new ArrayList<>();
    private final int bufferSize;

    public MemoryHandler(int bufferSize, MessageHandler... mHandlers) {
        this.bufferSize = bufferSize;
        messages.addAll(Arrays.asList(mHandlers));
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() >= bufferSize) {
            logBuffer();
        }
    }

    public void logBuffer() {
        for (MessageHandler m : messages) {
            for (String msg : buffer) {
                m.log(msg);
            }
        }
        buffer.clear();
    }
}
