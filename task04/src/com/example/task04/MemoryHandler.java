package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler{
    private ArrayList<MessageHandler> messageHandlers = new ArrayList<>();
    private final ArrayList<String> messages = new ArrayList<>();
    private final int amountOfMessages;

    public MemoryHandler(int maxLengthMessages, MessageHandler... handlers) {
        this.amountOfMessages = maxLengthMessages;
        messageHandlers.addAll(Arrays.asList(handlers));
    }

    public MemoryHandler(int maxLengthMessages, ArrayList<MessageHandler> messageHandlers){
        this.amountOfMessages = maxLengthMessages;
        this.messageHandlers = messageHandlers;
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() == amountOfMessages) {
            logMessage();
        }
    }

    public void logMessage() {
        for (MessageHandler handler : messageHandlers) {
            for (String msg : messages) {
                handler.log(msg);
            }
        }
        messages.clear();
    }

}
