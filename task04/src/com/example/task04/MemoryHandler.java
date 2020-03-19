package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private final MessageHandler handler;
    private final long bufferSize;
    private ArrayList<String> messages;

    public MemoryHandler(MessageHandler handler, long bufferSize){
            this.bufferSize = bufferSize;
            this.handler = handler;
            messages = new ArrayList<>();
        }

        @Override
        public void log(String message) {
            messages.add(message);
            if(messages.size() >= bufferSize) {
                for (String str : messages)
                    handler.log(str);
                messages.clear();
            }
        }
    }
