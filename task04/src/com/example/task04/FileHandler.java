package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    private String path;
    private String filename;

    public  FileHandler(String path, String filename){
        this.path = path;
        this.filename = filename;
    }

    @Override
    public void log(String message) throws IOException {
        FileWriter writer = new FileWriter(path+filename);
        writer.append(message);
    }
}
