package com.example.task04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RotationFileHandler extends FileHandler {

    private List<String> messages = new ArrayList<String>();

    public  RotationFileHandler(String filePath, int rotationInSeconds) {
        super(filePath);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(this::outInFile, 0, rotationInSeconds, TimeUnit.SECONDS);
    }

    private void outInFile(){
        if(messages.size() == 0)
            return;

        for(String msg : messages)
            super.output(msg);
    }

    @Override
    public void output(String message){
        messages.add(message);
    }
}
