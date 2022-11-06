package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler{

    private int maxMemorySize;
    private List<String> messages = new ArrayList<>();
    private List<MessageHandler> handlers = new ArrayList<>();

    public MemoryHandler(int maxSize, MessageHandler... handlers) {
        this.maxMemorySize = maxSize;
        ArrayList<MessageHandler> newHandlers = new ArrayList<>(Arrays.asList(handlers));
        this.handlers.addAll(newHandlers);
    }

    @Override
    public void logger(String message){
        messages.add(message);
        if (messages.size() > maxMemorySize) {
            sendMessageToHandler();
        }
    }

    public void sendMessageToHandler(){
        for (MessageHandler handler : handlers) {
            for (String message : messages)
                handler.logger(message);
            messages.clear();
        }
    }

}
