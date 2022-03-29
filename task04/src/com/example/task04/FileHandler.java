package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void handle(String message) {
        writeToFile(path, message);
    }
    private void writeToFile(String path, String message){
        try(FileWriter writer = new FileWriter(path, true))
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
