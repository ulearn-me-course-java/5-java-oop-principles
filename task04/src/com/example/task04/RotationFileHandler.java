package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RotationFileHandler implements MessageHandler{
    private RecordLog recordLog;
    private String folderName;
    private long gapInMilliseconds;
    public RotationFileHandler(long gapInMilliseconds, String folderName){
        this.gapInMilliseconds = gapInMilliseconds;
        this.folderName = folderName;
    }
    @Override
    public void publish(RecordLog recordLog){
        this.recordLog = recordLog;
        File file = new File(folderName);
        file.mkdir();

    }
    private void writeLog(String pathName){
        try(FileWriter writer = new FileWriter(folderName + "/" + pathName + ".txt", true))
        {
            String text = recordLog.getLogMessage();
            writer.write(text + "\n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
