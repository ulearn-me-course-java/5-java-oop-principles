package com.example.task04;

import java.io.FileWriter;

public class FileHandler implements MessageHandler {
    public String getPath() {
        return path;
    }

    private final String path;

    public FileHandler(String path){
        this.path = path;
    }

    @Override
    public void showMessage(String message) {
        try(FileWriter writer  = new FileWriter(path, true)) {
            writer.write(message);
            writer.append('\n');
            writer.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
