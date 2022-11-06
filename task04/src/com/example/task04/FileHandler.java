package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private String filePath;
    public FileHandler(){
        filePath = "message.txt";
    }
    public FileHandler(String path){
        filePath = path;
    }
    public void setFilePath(String path){
        this.filePath = path;
    }
    public String getFilePath() {
        return filePath;
    }
    public void log(String message){

        File file = new File(filePath);
        try(FileWriter writer = new FileWriter(filePath, true))
        {
            writer.write(message);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
