package com.example.task04;

import java.io.IOException;
import java.util.*;

public class MemoryHandler implements MessageHandler {

    private final int portion;

    private final List<String> fixedPortion = new ArrayList<>();

    private final List<MessageHandler> msgHandlers = new ArrayList<MessageHandler>();

    public MemoryHandler(int portion, MessageHandler... handlers) {
        this.portion = portion;
        msgHandlers.addAll(Arrays.asList(handlers));
    }

    @Override
    public void Handler(String msg) throws IOException {
        fixedPortion.add(msg);
        if (portion == fixedPortion.size())
            printing();

    }

    private void printing() throws  IOException {
        for (MessageHandler handler : msgHandlers) {
            for (String message : fixedPortion)
                handler.Handler(message);
        }
    }
}
