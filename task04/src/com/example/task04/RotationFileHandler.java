package com.example.task04;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class RotationFileHandler implements MessageHandler{
    private final FileWriter fileWriter;
    private StringBuilder messages;
    private final long mills;
    Timer timer;

    public RotationFileHandler(String filepath, Duration rotation) throws IOException
    {
        fileWriter = new FileWriter(filepath);
        mills = rotation.toMillis();
        timer = new Timer();
        startAlarm();
    }

    @Override
    public void hundle(String message)
    {
        messages.append(message + "\n");
    }

    private void startAlarm()
    {
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                if (messages.toString().equals(""))
                    return;
                try
                {
                    fileWriter.write(messages.toString());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                messages = new StringBuilder();
            }
        }, 0, mills);
    }
}
