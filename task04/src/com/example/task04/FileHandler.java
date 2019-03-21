package com.example.task04;

import java.io.FileWriter;

public class FileHandler implements MessageHandler {
    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void print(String msg) {
        try {
            FileWriter wr = new FileWriter(path, true);
            wr.write(msg);
            wr.write('\n');
            wr.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
