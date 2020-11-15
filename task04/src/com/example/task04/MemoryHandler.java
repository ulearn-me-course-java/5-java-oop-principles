package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler
{
    private final MessageHandler messageHandler;
    private ArrayList<String> buffer = new ArrayList<>();
    private final int capacity;

    public MemoryHandler(int capacity, MessageHandler messageHandler)
    {
        this.capacity = capacity;
        this.messageHandler = messageHandler;
    }

    @Override
    public void hundle(String message)
    {
        buffer.add(message);
        if (buffer.size() >= capacity)
            hundlePack();
    }

    private void hundlePack()
    {
        for (String message: buffer)
        {
            messageHandler.hundle(message);
        }
        buffer = new ArrayList<>();
    }
}
