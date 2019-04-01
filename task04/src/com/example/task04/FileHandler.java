package com.example.task04;
import java.io.*;
public class FileHandler implements MessageHandler{


    @Override
    public void print(String message) {
        try (FileWriter file = new FileWriter("C:/Users/Админ/Desktop/f/file1.txt", true)) {
            file.append(message);
            file.append('\n');
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
