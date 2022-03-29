package com.example.task04;

public class MemoryHandler implements MessageHandler {

    private final String[] texts;
    private final MessageHandler messageHandler;
    private int count;

    public MemoryHandler(int size, MessageHandler messageHandler) {
        texts = new String[size];
        this.messageHandler = messageHandler;
    }

    public int getTextSize() {
        return texts.length;
    }

    public String[] getTexts() {
        return texts;
    }

    @Override
    public void log(String text) {
        texts[count] = text;
        count++;
        if (count == getTextSize()) {
            for (String txt : texts) {
                messageHandler.log(txt);
            }
            count = 0;
        }
    }
}
