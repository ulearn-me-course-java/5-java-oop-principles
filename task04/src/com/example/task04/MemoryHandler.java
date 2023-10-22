package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler implements MessageHandler {
    private final int maxAmountMessages;
    private final ArrayList<String> messages = new ArrayList<>();
    private final ArrayList<MessageHandler> mesHandlers = new ArrayList<>();

    public MemoryHandler(int maxLenMessage, MessageHandler ... handlers){
        this.maxAmountMessages = maxLenMessage;
        this.mesHandlers.addAll(Arrays.asList(handlers));
    }

    public int getMaxAmountMessages() {
        return maxAmountMessages;
    }
    public ArrayList<MessageHandler> getHandler(){
        return mesHandlers;
    }
    public ArrayList<String> getMessages(){ return messages; }

    @Override
    public void handleMessage(String message){
        messages.add(message);
        if(messages.size() >= maxAmountMessages){
            for(String mes : messages){
                runHandleMessage(mes);
            }
            messages.clear();
        }
    }

    public void handleMessage(String format, Object ...objects){
        messages.add(String.format(format,objects));
        if(messages.size() >= maxAmountMessages){
            for(String mes:messages){
                runHandleMessage(mes);
            }
            messages.clear();
        }
    }

    private void runHandleMessage(String message){
        for(MessageHandler messageHandler : mesHandlers){
            messageHandler.handleMessage(message);
        }
    }
}
