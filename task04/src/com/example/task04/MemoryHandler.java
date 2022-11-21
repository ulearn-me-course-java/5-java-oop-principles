package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final int maxSize;
    private final List<String> messages = new ArrayList<>();
    private final List<MessageHandler> handlers = new ArrayList<>();

    public MemoryHandler(int maxSize, MessageHandler... handlers) {
        this.maxSize = maxSize;
        ArrayList<MessageHandler> newHandlers = new ArrayList<>(Arrays.asList(handlers));
        this.handlers.addAll(newHandlers);
    }

    @Override
    public void log(String msg) {
        messages.add(msg);
        if (messages.size() > maxSize) {
            sendMessageToHandler();
        }
    }

    public void sendMessageToHandler() {
        for (MessageHandler handler : handlers) {
            for (String message : messages)
                handler.log(message);
            messages.clear();
        }
    }
}
