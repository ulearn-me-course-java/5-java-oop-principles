package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {

    private final long size;
    private List<String> messages = new ArrayList<>();
    private final FileHandler handler;

    public MemoryHandler(long size, FileHandler handler) {
        this.size = size;
        this.handler = handler;
    }

    @Override
    public void showMessage(String message) {
        messages.add(message);
        if (messages.size() >= size){
            for (String msg: messages)
                handler.showMessage(msg);
            messages.clear();
        }
    }
}
