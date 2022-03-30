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
        if (!this.baseDirectory.exists()) this.baseDirectory.createNewFile();
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
        FileWriter writer;
        Optional<File> neededFile = Arrays.stream(baseDirectory.listFiles()).filter(file -> Calendar.getInstance(TimeZone.getDefault()).get(calendarConst) == Integer.valueOf(file.getName())).findFirst();
        try
        {
            if (neededFile != null) writer = new FileWriter(neededFile.get());
            else
                writer = new FileWriter(baseDirectory + String.valueOf(Calendar.getInstance(TimeZone.getDefault()).get(calendarConst)));
            writer.write(message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
