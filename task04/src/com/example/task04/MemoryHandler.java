package com.example.task04;

public class MemoryHandler implements MessageHandler {
    private final StringBuilder builder = new StringBuilder();
    private MessageHandler handler;
    private int countMessages;
    private int memorySize;

    public MemoryHandler(MessageHandler handler) {
        this(5, handler);
    }

    public MemoryHandler(int memorySize, MessageHandler handler) {
        this.memorySize = memorySize;
        this.handler = handler;
    }

    public MessageHandler getHandler() {
        return handler;
    }

    public void setHandler(MessageHandler handler) {
        this.handler = handler;
    }

    public int getCountMessages() {
        return countMessages;
    }

    public void setCountMessages(int countMessages) {
        this.countMessages = countMessages;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public void handleMessage(String message) {
        builder.append(message).append("\n");
        countMessages++;

        if (countMessages == memorySize) {
            freeMemory();
        }
    }

    public void freeMemory() {
        handler.handleMessage(builder.toString());
        builder.delete(0, builder.length());
        countMessages = 0;
    }
}
