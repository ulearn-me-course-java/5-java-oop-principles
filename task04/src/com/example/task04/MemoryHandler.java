package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler{
    private List<String> messages = new ArrayList<String>();

    private MessageHandler handler;
    private int memorySize;

    public int getMemorySize(){
        return this.memorySize;
    }

    public void setMemorySize(int size){
        this.memorySize = size;
    }


    public MemoryHandler(MessageHandler handler, int memorySize){
        this.handler = handler;
        this.memorySize = memorySize;
    }

    @Override
    public void log(String message){
        messages.add(message);

        if(messages.size() >= memorySize){
            for (String m: messages){
                this.handler.log(m);
            }
            messages.clear();
        }
    }
}
