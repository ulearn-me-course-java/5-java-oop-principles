package com.example.task04;

import java.lang.reflect.Array;
import java.util.*;

public class MemoryHandler implements MessageHandler {

    private final List<MessageHandler> mesList = new ArrayList<>();
    private final List<String> buf = new ArrayList<>();
    private final int size;

    public MemoryHandler(int size, MessageHandler... args) {
        this.size = size;
        mesList.addAll(Arrays.asList(args));
    }

    @Override
    public void log(String message) {
        buf.add(message);
        if (buf.size() > size) {
            logBuf();
        }
    }

    private void logBuf() {
        for (MessageHandler message : mesList) {
            for (String msg : buf) {
                message.log(msg);
            }
        }
    }
}
