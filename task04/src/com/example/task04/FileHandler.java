package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler implements MessageHandler {
    private final PrintWriter _printWriter;

    public FileHandler(String fileName) {
        try {
            _printWriter = new PrintWriter(new FileWriter(fileName + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processMessage(String currentName, LogSeverityLvl lvl, String message) {
        _printWriter.println(String.format("[%s] %s %s - %s",
                lvl,
                new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date()),
                currentName,
                message
                )
        );
        _printWriter.flush();
    }

    @Override
    public void processMessage(String format, Object... params) {
        _printWriter.println(String.format(format, params));
        _printWriter.flush();
    }
}
