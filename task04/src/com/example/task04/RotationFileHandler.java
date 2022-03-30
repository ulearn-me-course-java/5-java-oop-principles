package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RotationFileHandler implements MessageHandler
{
    private int calendarConst;
    private final File baseDirectory;

    public RotationFileHandler(int calendarConst, String baseDirectory) throws IOException
    {
        this.calendarConst = calendarConst;
        this.baseDirectory = new File(baseDirectory);
        if (!this.baseDirectory.exists()) this.baseDirectory.mkdir();
    }

    public int getCalendarConst()
    {
        return calendarConst;
    }

    public void setCalendarConst(int calendarConst)
    {
        this.calendarConst = calendarConst;
    }

    @Override
    public void Handle(String message)
    {
        File[] files = baseDirectory.listFiles();
        Optional<File> neededFile;
        FileWriter writer;
        if (files == null) neededFile = null;
        else
            neededFile = Arrays.stream(files).filter(file -> String.valueOf(Calendar.getInstance(TimeZone.getDefault()).get(calendarConst)) + ".txt" == file.getName()).findFirst();
        try
        {
            if (!neededFile.isEmpty()) writer = new FileWriter(neededFile.get(), true);
            else
            {
                File file = new File(baseDirectory + "/" + String.valueOf(Calendar.getInstance(TimeZone.getDefault()).get(calendarConst)) + ".txt");
                file.createNewFile();
                writer = new FileWriter(file, true);
            }
            writer.write(message);
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
