package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {
    private final String file;

    public FileHandler(String file) {
        this.file = file;
    }

    @Override
    public void printMessage(String string) {
        File newFile= new File(file);
        try (FileWriter writer = new FileWriter(newFile, true)) {
            writer.write(string + '\n');
            //Чтобы быть уверенным, что буфер будет очищен,
            //а все его данные запишутся в файл, вызывается метод flush
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}