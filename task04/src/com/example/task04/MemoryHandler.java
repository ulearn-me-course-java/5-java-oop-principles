package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final List<MessageHandler> messageHandlers = new ArrayList<>();
    private final List<String> buffer = new ArrayList<>();
    private final int bufferSize;

    public MemoryHandler(int bufferSize, MessageHandler... handlers){
        this.bufferSize = bufferSize;
        messageHandlers.addAll(Arrays.asList(handlers));
    }
    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() == bufferSize) {
            logBuffer();
        }
    }

    public void logBuffer() {
        for (MessageHandler handler : messageHandlers) {
            for (String message : buffer) {
                handler.log(message);
            }
        }
        buffer.clear();
    }
}
