package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    private String fileName;
    public FileHandler(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void writeMessage(String message){
        try (FileWriter fileWriter = new FileWriter(fileName,true)) {
                fileWriter.write(message);
        }catch (IOException ex){

        }
    }
}
