package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private List<MessageHandler> messages = new ArrayList<>();
    private List<String> buffer = new ArrayList<>();
    private int sizeBuffer;

    public MemoryHandler(int sizeBuffer, MessageHandler... messages) {
        this.sizeBuffer = sizeBuffer;
        this.messages.addAll(Arrays.asList(messages));
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() >= sizeBuffer) {
            logBuffer();
        }
    }

    public void logBuffer() {
        for (MessageHandler mesHander : messages) {
            for (String mes : buffer) {
                mesHander.log(mes);
            }
        }
        buffer.clear();
    }
}
