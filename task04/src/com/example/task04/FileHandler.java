package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    @Override
    public void writeMessage(String message){
        try (FileWriter fileWriter = new FileWriter("Logs.txt",true)) {
                fileWriter.write(message);
        }catch (IOException ex){

        }
    }
}
