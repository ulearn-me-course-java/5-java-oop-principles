package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    private String path;
    public FileHandler(String path){
        this.path = path;
    }
    @Override
    public void write(String message) {

        try (FileWriter fileWriter = new FileWriter(path,true)) {
            fileWriter.write(message+"\n");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
