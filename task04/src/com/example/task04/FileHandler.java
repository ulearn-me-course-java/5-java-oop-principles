package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    @Override
    public void Handler(String msg) throws IOException {
        File file = new File("log.txt");
        if (file.exists()) {
            writeInFile(msg, file);
        } else {
            file.createNewFile();
            writeInFile(msg, file);
        }
    }

    private void writeInFile(String msg, File file) {
        try (FileWriter writer = new FileWriter(file.getPath(), true)) {
            writer.append(msg);
        } catch (IOException exp) {
        }
    }
}
