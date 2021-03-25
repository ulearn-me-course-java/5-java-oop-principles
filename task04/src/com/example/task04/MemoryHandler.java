package com.example.task04;

import com.sun.xml.internal.ws.api.message.Message;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler handler;
    private final int size;
    private ArrayList<String> logs;

    MemoryHandler(MessageHandler handler, int size) {
        this.handler = handler;
        this.size = size;
        logs = new ArrayList<>();
    }

    public void log(String message) {
        logs.add(message);
        if (logs.size() == size) {
            getLogs();
        }
    }
    public void getLogs() {
        for (String log: logs) {
            handler.log(log);
            logs.clear();
        }
    }
}
