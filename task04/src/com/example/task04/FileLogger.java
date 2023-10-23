package com.example.task04;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileLogger implements ILogger{
    private String path;
    public FileLogger(String path){
        this.path = path;
    }
    public void log(String message){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(message);

            writer.close();
        } catch (Exception ex){
            System.out.println("Error");
        }
    }
}
