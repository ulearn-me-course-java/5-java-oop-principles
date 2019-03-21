package com.example.task04;

import java.util.Date;

public class RotationFileHandler implements MessageHandler {

    private String path;
    private int interval;
    private Date lastDate;

    public RotationFileHandler(String path, int intervalInSecs){
        this.path = path;
        this.lastDate = new Date();
        this.interval = intervalInSecs;
    }

    @Override
    public void showMessage(String message) {
        if((lastDate.getTime() - new Date().getTime()) / 1000 > interval)
            path = newFileName(path);
        new FileHandler(path).showMessage(message);
    }

    private String newFileName(String oldPath){
        int directory = oldPath.lastIndexOf('/');
        return oldPath.substring(0, directory).concat(new Date().toString());
    }
}
