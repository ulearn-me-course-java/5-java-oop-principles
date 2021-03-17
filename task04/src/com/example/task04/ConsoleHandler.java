package com.example.task04;

import java.util.logging.Logger;

public class ConsoleHandler implements MessageHandler {
    public void log(String message) {
        System.out.println(message);
    }
}
