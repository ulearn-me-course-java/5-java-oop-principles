package com.example.task04;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

/**
 * MemoryHandler - обработчик-прокси, который аккумулирует сообщения в памяти (список строк messages)
 * и при достижении определенного объема, задаваемого полем limit, а также при завершении программы
 * отправляет их в проксируемый обработчик.
 */
public class MemoryHandler implements MessageHandler {
    long limit;
    private List<String> messages = new ArrayList<>();
    private final MessageHandler destination;

    public MemoryHandler(long limit, MessageHandler destination) {
        this.limit = limit;
        this.destination = destination;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (String m : messages) {
                destination.printMessage(m);
            }
            messages.clear();
        }));
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
    }
}
