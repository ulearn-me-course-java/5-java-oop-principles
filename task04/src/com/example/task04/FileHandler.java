package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    @Override
    public void handleMessage(String message){
        try(FileWriter fileWriter = new FileWriter("Message.txt", true))
        {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void handleMessage(String format, Object ...objects){
        try(FileWriter fileWriter = new FileWriter("Message.txt", true))
        {
            fileWriter.write(String.format(format, objects) + "\n");
            fileWriter.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
