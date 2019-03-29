package com.example.task04;

import java.util.ArrayDeque;

public class MemoryHandler implements MessageHandler  {
    private ArrayDeque<String> messagesList = new ArrayDeque<String>();
    private int messagesLimit;
    MessageHandler dst;

    public MemoryHandler(int messagesLimit, MessageHandler dst) {
        this.messagesLimit = messagesLimit;
        this.dst = dst;
    }

    public void printMessage(String message) {
        messagesList.add(message);
        if (messagesList.size() >= messagesLimit)
            pullAllMessages();
    }

    public void pullAllMessages() {
        while (messagesList.size() != 0)
            dst.printMessage(messagesList.pollFirst());
    }
}
