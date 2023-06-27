package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private String pathName;
    private RecordLog recordLog;
    public FileHandler(String pathName){
        this.pathName = pathName;
    }
    @Override
    public void publish(RecordLog recordLog) {
        this.recordLog = recordLog;
        writeLog();
    }
    private void writeLog(){
        try(FileWriter writer = new FileWriter(pathName + ".txt", true))
        {
            String text = recordLog.getLogMessage();
            writer.write(text + "\n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
