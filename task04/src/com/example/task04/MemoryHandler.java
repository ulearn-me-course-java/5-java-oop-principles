package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler
{
    private final ArrayList<MessageHandler> handlers = new ArrayList<>();
    private final ArrayList<String> messages = new ArrayList<>();

    @Override
    public void Handle(String message)
    {
        messages.add(message);
    }

    public void log()
    {
        for (MessageHandler handler : handlers)
        {
            for (String message : messages)
            {
                handler.Handle(message);
            }
        }
        messages.clear();
    }

    public ArrayList<MessageHandler> getHandlers()
    {
        return handlers;
    }
}
