package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final int maxMessages;
    private final ArrayList<String> messages = new ArrayList<>();
    private final ArrayList<MessageHandler> messageHandlers;

    public MemoryHandler(int maxMessages, ArrayList<MessageHandler> messageHandlers) {
        this.maxMessages = maxMessages;
        this.messageHandlers = messageHandlers;
    }

    public void log(String message) {
        messages.add(message);

        if(messages.size() >= maxMessages) {
            for(MessageHandler messageHandler : messageHandlers) {
                for(String msg : messages) {
                    messageHandler.log(msg);
                }
            }
            messages.clear();
        }
    }
}