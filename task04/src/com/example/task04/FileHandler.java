package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {

    BufferedWriter bufWriter;

    /**
     * @param filePath путь к файлу, в который будут записываться сообщения
     */
    public FileHandler(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, true);
        bufWriter = new BufferedWriter(fileWriter);
    }

    @Override
    public void log(String message) {
        try {
            bufWriter.write(message + '\n');
            bufWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}