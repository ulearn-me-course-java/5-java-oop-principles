package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler{

    private final int length;
    private List<String> memory = new ArrayList<>();
    private final MessageHandler handler;

    public MemoryHandler(int length, MessageHandler handler){
        this.length = length;
        this.handler = handler;
    }

    @Override
    public void print(String message) {
        memory.add(message);

        if (memory.size() >= length){
            for (String line: memory)
                handler.print(line);
            memory.clear();
        }
    }
}