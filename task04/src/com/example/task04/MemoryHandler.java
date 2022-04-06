package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{
    private int maxSize;
    private MessageHandler messageHandler;
    private static ArrayList<String> allMessages = new ArrayList<>();

    public MemoryHandler(MessageHandler messageHandler, int maxSize){
        this.maxSize = maxSize;
        this.messageHandler = messageHandler;
    }

    @Override
    public void log(String message){
        allMessages.add(message);
        if(allMessages.size() >= maxSize){
            for(String item : allMessages){
                messageHandler.log(item);
            }
            allMessages.clear();
        }
    }
}
