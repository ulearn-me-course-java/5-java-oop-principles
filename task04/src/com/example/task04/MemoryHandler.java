package com.example.task04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private List<MessageHandler> handlers;
    private final List<String> buffer;
    private final int bufferSize;

    public MemoryHandler( int bufferSize, MessageHandler... handlers) {
        this.buffer = new ArrayList<>();
        this.bufferSize = bufferSize;
        this.handlers = Arrays.asList(handlers);

    }

    @Override
    public void log(String message) throws IOException {
        buffer.add(message);
        if (buffer.size() == bufferSize) {
            logBuffer();
        }
    }

    public void logBuffer() throws IOException {
        for (MessageHandler handler : handlers) {
            for (String msg : buffer) {
                handler.log(msg);
            }
        }
        buffer.clear();
    }
}
