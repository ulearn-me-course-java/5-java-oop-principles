package com.example.task04;
import java.io.*;

import java.io.FileWriter;

public class FileHandler implements MessageHandler{

    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter("log.txt", true)){
            writer.write(message);
            writer.append("\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
