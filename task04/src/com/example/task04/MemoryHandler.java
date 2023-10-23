package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final int maxMemorySize;
    private final List<String> messages = new ArrayList<>();
    private final List<MessageHandler> handlers = new ArrayList<>();

    public MemoryHandler(int maxMemorySize, MessageHandler... handlers) {
        this.maxMemorySize = maxMemorySize;
        ArrayList<MessageHandler> newHandlers = new ArrayList<>(Arrays.asList(handlers));
        this.handlers.addAll(newHandlers);
    }

    @Override
    public void log(String message){
        messages.add(message);
        if (messages.size() > maxMemorySize) {
            sendMessageToHandler();
        }
    }

    public void sendMessageToHandler(){
        for (MessageHandler handler : handlers) {
            for (String message : messages)
                handler.log(message);
            messages.clear();
        }
    }
}
