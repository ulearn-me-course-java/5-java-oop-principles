package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler{

    private String fileName;
    public FileHandler(String fileName){
        this.fileName = fileName;
    }
    public void setFileName(){
        this.fileName = fileName;
    }
    public String getFileName(){
        return fileName;
    }
    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(MessageFormat.format("{0}.txt",fileName), false))
        {
            writer.write(String.format("%s", message));
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
