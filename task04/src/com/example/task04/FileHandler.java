package com.example.task04;

import java.io.FileWriter;

public class FileHandler implements MessageHandler{
    private String fileName;

    public  FileHandler(){
        this("messages.txt");
    }

    public FileHandler(String fileName){
        this.fileName=fileName;
    }

    @Override
    public void log(String message) {

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(message);
            writer.append("\n");
            writer.flush();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
