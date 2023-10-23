package com.example.task04;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private final String fileName;

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    public FileHandler(){
        this.fileName = "log";
    }
    @Override
    public void log(String message){
        try {
            FileWriter writer = new FileWriter(String.format(String.format("{0}.txt",fileName)), true);
            writer.write(String.format("%s\n", message));
            writer.close();

        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }
}
