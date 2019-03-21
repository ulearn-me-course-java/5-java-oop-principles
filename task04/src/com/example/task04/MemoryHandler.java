package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {

    private final long size;
    private List<String> messages = new ArrayList<>();
    private final FileHandler fh;

    public MemoryHandler(long size, FileHandler fh) {
        this.size = size;
        this.fh = fh;
    }

    @Override
    public void showMessage(String message) {
        messages.add(message);
        if (messages.size() >= size){
            for (String msg: messages)
                fh.showMessage(msg);
            messages.clear();
        }
    }
}
