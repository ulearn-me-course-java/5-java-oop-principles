package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{

    private final MessageHandler handler;
    private final int size;
    ArrayList<String> logs = new ArrayList<>();

    public MemoryHandler(MessageHandler handler, int size) {
        this.handler = handler;
        this.size = size;
    }

    @Override
    public void logMessage(String message) {
        logs.add(message);
        if (logs.size() == size) {
            showMessage();
        }
    }

    public void showMessage() {
        for (String log : logs) {
            handler.logMessage(log);
        }
        logs.clear();
    }
}
