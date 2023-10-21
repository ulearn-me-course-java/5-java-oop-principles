package com.example.task04;

import com.sun.org.apache.xalan.internal.xsltc.runtime.MessageHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler implements Handler {
    private ArrayList<Handler> handlers;
    private ArrayList<String> messages;
    private final int bufferSize;

    public MemoryHandler(int bufferSize, Handler... handlers) {
        this.bufferSize = bufferSize;
        this.messages = new ArrayList<>();
        this.handlers.addAll(Arrays.asList(handlers));
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if(messages.size() >= bufferSize) {
            logMessages();
        }
    }

    private void logMessages(){
        for (Handler handler : handlers) {
            for (String message : messages) {
                handler.log(message);
            }
        }
        messages.clear();
    }
}
