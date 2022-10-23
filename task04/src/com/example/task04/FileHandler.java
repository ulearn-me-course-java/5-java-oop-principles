package com.example.task04;

import com.sun.istack.internal.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler implements MessageHandler {
    private final FileWriter _fileWriter;

    public FileHandler(@NotNull String fileName) {
        try {
            _fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processMessage(String currentName, LogSeverityLvl lvl, String message) {
        try {
            _fileWriter.write(String.format("[%s] %s %s - %s",
                    lvl,
                    new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date()),
                    currentName,
                    message
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processMessage(String format, Object... params) {
        try {
            _fileWriter.write(String.format(format, params));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
