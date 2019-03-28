package com.example.task04;

import java.util.*;
/**
 * обработчик - прокси, который может аккумулировать сообщения
 * в памяти и при необходимости (явном вызове метода или при достижении определенного объема)
 * отправлять их в проксируемый обработчик.
 * <p>
 * Например, с помощью данного класса мы должны уметь отправлять сообщения в консоль (или файл),
 * но только определенными "порциями".
 */
public class MemoryHandler implements MessageHandler {
    private static ArrayList<String> messages = new ArrayList<String>();
    private final int size;
    private final MessageHandler handler;

    public MemoryHandler(MessageHandler handler, int size) {
        this.handler = handler;
        this.size = size;
    }

    @Override
    public void printMessage(String string) {
        messages.add(string);
        if (messages.size() == size) {
            for (String mess : messages) {
                handler.printMessage(mess);
            }
            messages.clear();
        }
    }
}
