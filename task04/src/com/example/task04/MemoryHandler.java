package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler{
    private List<MessageHandler> messageHandlers = new ArrayList<>();
    private List<String> buffer = new ArrayList<>();
    private int bufferSize;

    public MemoryHandler(int bufferSize, MessageHandler... handlers) {
        this.bufferSize = bufferSize;
        messageHandlers.addAll(Arrays.asList(handlers));
    }
    public MemoryHandler(int bufferSize) {
        this.bufferSize = bufferSize;
    }
    public MemoryHandler(MessageHandler... handlers) {
        messageHandlers.addAll(Arrays.asList(handlers));
    }
    public MemoryHandler() {

    }

    public void addMessageHandlers(MessageHandler... handlers){
        messageHandlers.addAll(Arrays.asList(handlers));
    }
    public void setBufferSize(){
        this.bufferSize = bufferSize;
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() == bufferSize) {
            logBuffer();
        }
    }

    private void logBuffer() {
        for (MessageHandler handler : messageHandlers) {
            for (String msg : buffer) {
                handler.log(msg);
            }
        }
        buffer.clear();
    }
}
