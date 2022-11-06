package com.example.task04;

import java.io.FileWriter;
public class FileHandler implements MessageHandler{
    private final String fileName;
    public FileHandler(String fileName){
        this.fileName = fileName;
    }
    public FileHandler(){
        this.fileName = "log";
    }
    @Override
    public void log(String message){
        try(FileWriter writer = new FileWriter(String.format("{0}.txt",fileName), true)) {
            writer.append(String.format("%s\n", message));
            writer.flush();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
