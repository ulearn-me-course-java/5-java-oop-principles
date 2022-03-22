package com.example.task04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler implements MessageHandler{
    private final int size;

    private final ArrayList<String> fixedSize = new ArrayList<>();

    private final ArrayList<MessageHandler> messageHandlers = new ArrayList<MessageHandler>();

    public MemoryHandler(int size, MessageHandler... handlers) {
        this.size = size;
        messageHandlers.addAll(Arrays.asList(handlers));
    }

    @Override
    public void Handler(String message) throws IOException {
        fixedSize.add(message);
        if (size == fixedSize.size())
            printing();

    }

    private void printing() throws  IOException {
        for (MessageHandler handler : messageHandlers) {
            for (String message : fixedSize)
                handler.Handler(message);
        }
    }
}
