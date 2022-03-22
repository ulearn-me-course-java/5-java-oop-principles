package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    public final String path = "task04\\src\\log.txt";
    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(path, true)){
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error in FileHandler");
        }
    }
}
