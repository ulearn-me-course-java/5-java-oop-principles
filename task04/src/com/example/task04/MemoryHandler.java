package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler{
    private final List<MessageHandler> messages = new ArrayList<>();
    private final int bufferMaxSize;
    private final List<String> buffer = new ArrayList<>();

    public MemoryHandler(int bufferSize, MessageHandler... messages) {
        this.bufferMaxSize = bufferSize;
        this.messages.addAll(Arrays.asList(messages));
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() >= bufferMaxSize) {
            for (MessageHandler m : messages) {
                for (String s : buffer) m.log(s);
            }
            buffer.clear();
        }
    }
}
