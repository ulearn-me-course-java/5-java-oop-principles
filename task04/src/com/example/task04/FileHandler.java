package com.example.task04;
import java.io.FileWriter;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler{
    private String fileName = "log";

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    public FileHandler(){

    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(MessageFormat.format("{0}.txt", fileName), true)) {
            writer.append(String.format("%s\n", message));
            writer.flush();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
