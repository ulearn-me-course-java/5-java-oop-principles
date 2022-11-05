package com.example.task04;

import java.io.IOException;

public interface MessageHandler {
    void processMessage(String currentName, LogSeverityLvl lvl, String message);
    void processMessage(String format, Object... params);
}
