package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private String filePath;

    public  FileHandler(String filePath) {
        this.filePath = filePath;

        File file = new File(filePath);

        try {
            if (!file.exists())
                file.createNewFile();
        }
        catch(Exception e) {
            System.out.println("Unable to create file");
        }
    }

    public void output(String message){

        try (FileWriter file = new FileWriter("C:/Users/Админ/Desktop/f/file1.txt", true)) {

            file.append(message);
            file.append('\n');
            file.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
