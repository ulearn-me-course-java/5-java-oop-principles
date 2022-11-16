package com.example.task04;
import java.io.*;

public class FileHandler implements MessageHandler {

    private String path;

    public FileHandler(String path){
        if(path == null) throw new IllegalArgumentException("enter file path");
        else this.path = path;
    }

    @Override
    public void toWrite(String message) {
        try(FileWriter writer = new FileWriter(path, true)) {
            writer.write(message);
            writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
