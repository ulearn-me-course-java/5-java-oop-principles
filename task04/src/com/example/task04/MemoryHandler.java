package com.example.task04;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    long limitAmount;
    private List<String> listOfMessages = new ArrayList<>();

    public MemoryHandler(long limitAmount) {
        this.limitAmount = limitAmount;
    }

    @Override
    public void print(String message) {
        listOfMessages.add(message);
        if (listOfMessages.size() > limitAmount) {
            try (FileWriter file = new FileWriter("C:/Users/Админ/Desktop/f/file1.txt", true)){
            for (String el : listOfMessages
            ) {

                    file.append(el);
                    file.append('\n');
                    file.flush();

            }
            } catch (IOException e) {
            e.printStackTrace();
        }

        }listOfMessages.clear();
    }
}