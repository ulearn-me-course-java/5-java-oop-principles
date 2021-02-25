package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private final MessageHandler handler;
    private final int size;
    private ArrayList<String> logs;

    public MemoryHandler(MessageHandler handler, int size) {
        this.handler = handler;
        logs = new ArrayList<>();
        this.size = size;
    }

    @Override
    public void log(String message) {
        logs.add(message);
        if (logs.size() == size)
            sendLogs();
    }

    public void sendLogs(){
        for (String log: logs)
            handler.log(log);
        logs.clear();
    }
}
