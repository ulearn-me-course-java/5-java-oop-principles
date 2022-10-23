package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler{

    private int memSize;
    private List<MessageHandler> mesHandlers = new ArrayList<>();
    private List<String> messages = new ArrayList<>();

    public MemoryHandler(int memSize, MessageHandler... mesHandlers){
        this.memSize = memSize;
        this.mesHandlers.addAll(Arrays.asList(mesHandlers));
    }
    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() >=  memSize)
        {
            memSizeLog();
        }
    }

    private void memSizeLog(){
        for (int i = 0; i < mesHandlers.size(); i++){
            for (int j = 0; j < messages.size(); j++){
                mesHandlers.get(i).log(messages.get(j));
            }
        }
        messages.clear();
    }
}
