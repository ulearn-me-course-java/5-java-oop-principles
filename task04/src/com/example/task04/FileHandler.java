package com.example.task04;
import java.io.IOException;
import java.io.*;

public class FileHandler implements MessageHandler{
    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(this.path, true))
        {
            writer.write(message);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
