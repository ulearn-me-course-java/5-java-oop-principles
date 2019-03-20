package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final int size;
    private List<String> messages = new ArrayList<>();
    private FileHandler fileHandler;

    public MemoryHandler(FileHandler fileHandler, int size) {
        this.fileHandler = fileHandler;
        this.size = size;
    }

    @Override
    public void showMessage(String message) {
        messages.add(message);
        if (messages.size() >= size){
            for (String m: messages)
                fileHandler.showMessage(m);
            messages.clear();
        }

    }
}
