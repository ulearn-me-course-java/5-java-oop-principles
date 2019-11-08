package com.example.task04;

import lombok.NonNull;

/**
 * Интерфейс, реализующий конечную обработку сообщений логгера.
 */
public interface MessageHandler {
    void printMessage(@NonNull String message);
}
