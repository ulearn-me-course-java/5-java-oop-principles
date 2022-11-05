package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class RotationFileHandler implements MessageHandler {
    private final String _fileName;
    private final ChronoUnit _chronoUnit;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit) {
        _fileName = fileName;
        _chronoUnit = chronoUnit;
    }

    @Override
    public void processMessage(String currentName, LogSeverityLvl lvl, String message) {
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime time = nowTime.truncatedTo(_chronoUnit);
        try {
            FileWriter _fileWriter = new FileWriter(_fileName + "_" +
                    time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss")) + ".txt", true);

            _fileWriter.write(String.format("[%s] %s %s - %s\n",
                    lvl,
                    nowTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    currentName,
                    message)
            );

            _fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processMessage(String format, Object... params) {
        LocalDateTime time = LocalDateTime.now().truncatedTo(_chronoUnit);
        FileWriter _fileWriter = null;
        try {
            _fileWriter = new FileWriter(_fileName + "_" +
                    time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss")) + ".txt", true);
            _fileWriter.append(String.format(format, params));
            _fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
