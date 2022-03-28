package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {
    @Override
    public void handle(String message) {
        writeToFile("messages.txt", message);
    }

    public void writeToFile(String fileName, String message) {
        try(FileWriter fileWriter = new FileWriter(fileName, true))
        {
            fileWriter.write(message);
            fileWriter.write("\n");
            fileWriter.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
