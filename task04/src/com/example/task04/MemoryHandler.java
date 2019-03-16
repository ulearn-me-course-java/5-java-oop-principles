package com.example.task04;

import java.util.ArrayDeque;
import java.util.Queue;

public class MemoryHandler extends ConsoleHandler {
    private final int limitMessages;
    private final Queue<String> queueMessages;

    public MemoryHandler(int limitMessages) {
        this.limitMessages = limitMessages;
        queueMessages = new ArrayDeque<>(limitMessages);
    }

    public void printAllMessagesInMemory() {
        while(queueMessages.size() != 0)
            super.printMessage(queueMessages.poll());
    }

    @Override
    public void printMessage(String message) {
        queueMessages.add(message);
        if(queueMessages.size() >= limitMessages)
            printAllMessagesInMemory();
    }
}
