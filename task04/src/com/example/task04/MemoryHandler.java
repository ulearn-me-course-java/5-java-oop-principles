package com.example.task04;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

/**
 * MemoryHandler - обработчик-прокси, который аккумулирует сообщения в памяти (список строк messages)
 * и при достижении определенного объема, задаваемого полем limit, отправляет их в проксируемый обработчик.
 */
public class MemoryHandler implements MessageHandler {
    long limit;
    private List<String> messages = new ArrayList<>();
    private final MessageHandler destination;

    public MemoryHandler(long limit, MessageHandler destination) {
        this.limit = limit;
        this.destination = destination;
    }

    @Override
    public void printMessage(@NonNull String message) {
        messages.add(message);
        if (messages.size() > limit) {
            for (String m : messages) {
                destination.printMessage(m);
            }
            messages.clear();
        }
        try {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.out.println("---Shutdown Hook---");
                    messages.clear();
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
