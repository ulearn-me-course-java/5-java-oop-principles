package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryLogger implements ILogger
{
    private List<String> messages = new ArrayList<>();
    private int counter = 0;
    private ILogger logger;

    public MemoryLogger(ILogger logger)
    {
        this.logger = logger;
    }
    @Override
    public void log(String message)
    {
        messages.add(message);

        if(messages.size() >= 2)
        {
            for(String m : messages)
                this.logger.log(m);
            messages.clear();
        }
    }
}
