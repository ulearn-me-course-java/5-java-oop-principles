package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{
    private ArrayList<String> messages = new ArrayList<String>();
    private final int messagesArrayMaxSize;
    private MessageHandler messageHandler;
    public MemoryHandler(int messagesArrayMaxSize,MessageHandler messageHandler){
        this.messagesArrayMaxSize = messagesArrayMaxSize;
        this.messageHandler = messageHandler;
    }
    @Override
    public void writeMessage(String message){
        messages.add(message);
        if (messages.size()==messagesArrayMaxSize){
            for (String s:
                 messages) {
                messageHandler.writeMessage(s);
            }
        }
    }
}
