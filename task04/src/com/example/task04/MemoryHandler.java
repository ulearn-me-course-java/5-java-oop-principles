package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private int maxMessagesAmount;
    private ArrayList<String> messages = new ArrayList<>();
    private ArrayList<MessageHandler> messageHandlers = new ArrayList<>();

    public MemoryHandler(int maxMessagesAmount, ArrayList<MessageHandler> messageHandlers) {
        this.maxMessagesAmount = maxMessagesAmount;
        this.messageHandlers = messageHandlers;
    }

    @Override
    public void log(String message) {
        messages.add(message);

        if(messages.size() >= maxMessagesAmount) {
            for(MessageHandler messageHandler : messageHandlers) {
                for(String cachedMessage : messages) {
                    messageHandler.log(cachedMessage);
                }
            }
            messages.clear();
        }
    }
}
