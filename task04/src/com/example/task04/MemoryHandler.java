package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler extends FileHandler {

    private int maxMessages = 0;
    private List<String> messages = new ArrayList<String>();

    public MemoryHandler(String filePath, int maxMessages){
        super(filePath);
    }

    @Override
    public void output(String message){
        messages.add(message);

        if(messages.size() >= maxMessages) {

            for (String msg : messages)
                super.output(msg);

            messages.clear();
        }
    }
}
