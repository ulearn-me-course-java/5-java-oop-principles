package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{
    private final MessageHandler handler;
    private final int size;
    private ArrayList<String> logs;

    public MemoryHandler(MessageHandler handler, int size) {
        this.handler = handler;
        this.size = size;
        logs = new ArrayList<>();
    }

    @Override
    public void log(String message) {
        logs.add(message);
        if(logs.size() == size)
            sendLogs();
    }

    private void sendLogs(){
        for(String log : logs){
            handler.log(log);
        }
        logs.clear();
    }
}
