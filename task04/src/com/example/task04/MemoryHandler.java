package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{

    private final MessageHandler handler;
    private final int size;
    private ArrayList<String> logs = new ArrayList<>();

    public MemoryHandler(int size, MessageHandler handler){
        this.size = size;
        this.handler = handler;
    }

    @Override
    public void log(String message) {
        logs.add(message);
        if(logs.size() == size)
            showMessages();

    }

    public void showMessages(){
        for (String log:
             logs) {
            handler.log(log);
        }
        logs.clear();
    }
}
