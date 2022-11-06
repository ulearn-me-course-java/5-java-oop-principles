package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String _fileName;
    private final ChronoUnit _chronoUnit;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit) {
        _fileName = fileName;
        _chronoUnit = chronoUnit;
    }

    @Override
    public void processMessage(String message) {
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime time = nowTime.truncatedTo(_chronoUnit);
        try {
            FileWriter _fileWriter = new FileWriter(_fileName + "_" +
                    time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss")) + ".txt", true);

            _fileWriter.write(message);

            _fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
