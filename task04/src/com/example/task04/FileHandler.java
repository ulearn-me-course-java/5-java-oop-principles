package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    @Override
    public void log(String message) {
        String path = "task04\\src\\log.txt";

        try (FileWriter fw = new FileWriter(path, true)){
            fw.write(message + "\n\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file handler error");
        }
    }
}
