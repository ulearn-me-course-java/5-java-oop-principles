package com.example.task04;

public class MemoryHandler implements MessageHandler{
    private StringBuilder stringBuilder = new StringBuilder();
    private final int maxCount;
    private final MessageHandler handler;
    private int count = 0;
    public MemoryHandler(int maxCount, MessageHandler handler){
        this.maxCount = maxCount;
        this.handler = handler;
    }
    @Override
    public void log(String message) {
        if(count== maxCount){
            count = 0;
            logMessages();
            clearMemory();
        }
        count++;
        stringBuilder.append(message).append("\r\n");
    }
    public void logMessages(){
        handler.log(stringBuilder.toString());
    }
    private void clearMemory(){
        stringBuilder = new StringBuilder();
    }
}

