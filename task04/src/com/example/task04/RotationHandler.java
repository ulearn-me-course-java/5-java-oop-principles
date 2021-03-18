package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class RotationHandler implements MessageHandler {
    private final String path;
    private final Duration rotation;

    public RotationHandler(Duration rotation, String path){
        this.rotation = rotation;
        this.path = path;
    }

    @Override
    public void log(String message) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> doWrite(message), 0, rotation.toMillis(), TimeUnit.MILLISECONDS);

    }


    private void doWrite(String message) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        File f = new File(path, String.format("%s.txt", dt.format(new Date())));
        try (FileWriter writer = new FileWriter(f.getAbsolutePath(), true)) {
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
