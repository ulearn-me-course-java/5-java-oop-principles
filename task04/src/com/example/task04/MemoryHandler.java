package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler{

    private int maxSize;
    private List<MessageHandler> messageHelder = new ArrayList<>();
    private List<String> messages = new ArrayList<>();

    public MemoryHandler(int size, MessageHandler... handler){
        maxSize = size;
        messageHelder.addAll(Arrays.asList(handler));
    }

    public void editSize(int size){
        maxSize = size;
    }


    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() > maxSize) {sendMessage();}
    }

    private void sendMessage(){
        for (MessageHandler handler : messageHelder) {
            for (String message : messages)
                handler.log(message);

        }
        messages.clear();
    }


}
