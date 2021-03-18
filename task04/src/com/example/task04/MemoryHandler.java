package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.*;

public class MemoryHandler extends Logger
        implements MessageHandler {

    private final Queue<String> logs;
    private final int bufferSize;

    public MemoryHandler(String name, int bufferSize) {
        super(name);
        logs = new ArrayDeque<>();
        this.bufferSize = bufferSize;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    @Override
    public void log(Level logLevel, String message) {
        Date now = new Date();
        SimpleDateFormat nowFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String text = ("[" + logLevel + "] " + nowFormat.format(now) + " " + getName() + " - " + message);
        if (logs.size() < bufferSize) {
            logs.offer(text);
        } else {
            while (logs.size() > 0) {
                System.out.println(logs.poll());
            }
            logs.offer(text);
        }
    }

    @Override
    public void log(Level logLevel, String template, Object... args) {
        log(logLevel, String.format(template, args));
    }

}
