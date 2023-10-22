package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    private String fileName;
    public FileHandler(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(fileName, true))
        {
            writer.write(message);
            writer.write("\n");
            writer.flush();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

