package com.example.task04.handler;

public class MemoryHandler implements MessageHandler {
    private final StringBuilder stringBuilder = new StringBuilder();
    private MessageHandler handler;

    public MessageHandler getHandler() {
        return handler;
    }

    public void setHandler(MessageHandler handler) {
        this.handler = handler;
    }

    private int messagesCount;

    public int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    private final int memorySize;

    public int getMemorySize() {
        return memorySize;
    }

    public MemoryHandler(MessageHandler handler) {
        this(10, handler);
    }

    public MemoryHandler(int memorySize, MessageHandler handler) {
        this.memorySize = memorySize;
        this.handler = handler;
    }

    @Override
    public void handleMessage(String message) {
        stringBuilder.append(message).append("\n");
        if (++messagesCount == memorySize) {
            freeMemory();
        }
    }

    public void freeMemory() {
        handler.handleMessage(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());
        messagesCount = 0;
    }
}
