package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler implements Handler {
    private Handler handler;
    private ArrayList<String> messages;
    private final int bufferSize;

    public MemoryHandler(int bufferSize, Handler handler) {
        this.bufferSize = bufferSize;
        this.messages = new ArrayList<>();
        this.handler = handler;
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if(messages.size() >= bufferSize) {
            logMessages();
        }
    }

    private void logMessages(){
        for (String message : messages) {
            handler.log(message);
        }
        messages.clear();
    }
}