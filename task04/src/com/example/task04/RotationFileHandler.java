package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String fileName;
    private final ChronoUnit chronoUnit;

    public RotationFileHandler (String fileName, ChronoUnit chronoUnit) {
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    public RotationFileHandler(String fileName) {
        this(fileName, ChronoUnit.HOURS);
    }

    @Override
    public void log(String message) {
        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(this.chronoUnit);
        try (FileWriter fileWriter = new FileWriter(MessageFormat.format(
                "{0}-{1}.txt",
                fileName,
                dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh:mm:ss"))),
                true))
        {
            fileWriter.append(String.format("%s\n", message));
            fileWriter.flush();
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
