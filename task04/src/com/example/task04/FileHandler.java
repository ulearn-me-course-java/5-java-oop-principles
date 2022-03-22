package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    @Override
    public void Handler(String message) throws IOException {
        File file = new File("log.txt");
        if (file.exists()) {
            writeFile(message, file);
        }
        else {
            file.createNewFile();
            writeFile(message, file);
        }
    }

    private void writeFile(String message, File file) {
        try (FileWriter writer = new FileWriter(file.getPath(), true)) {
            writer.append(message);
        } catch (IOException exp) {
        }
    }
}
