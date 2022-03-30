package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler
{
    private final FileWriter writer;

    public FileHandler(String path) throws IOException
    {
        File file = new File(path);
        if (!file.exists()) file.createNewFile();
        writer = new FileWriter(path, true);
    }

    @Override
    public void Handle(String message)
    {
        try
        {
            writer.write(message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
