package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private final String fileName;

    public String getFileName(){
        return this.fileName;
    }

    public FileHandler(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void log(String message){
        try (FileWriter messagesFile = new FileWriter(fileName, true)){
            messagesFile.write(message);
            messagesFile.append("\n");
            messagesFile.flush();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
