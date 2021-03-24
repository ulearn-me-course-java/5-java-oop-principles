package com.example.task04;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    private final FileWriter fileWriter;

    public FileHandler(String filePath) throws IOException
    {
        fileWriter = new FileWriter(filePath);
    }

    @Override
    public void hundle(String message)
    {
        try
        {
            fileWriter.write(message + '\n');
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
