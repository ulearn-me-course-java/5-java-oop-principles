package com.example.task04;

import java.time.Duration;
import  java.util.Date;

public class RotationFileHandler implements MessageHandler {
    private String path;
    private Duration dur;
    private long time;

    public RotationFileHandler(String path, Duration dur){
        this.dur = dur;
        this.path = path;
    }

    public String createPath(String p, String t){
        int indx = p.lastIndexOf('\\');

        if(indx == -1){
            indx = p.lastIndexOf('/');
        }

        return p.substring(0, indx).concat(t);
    }

    @Override
    public void print(String msg) {
        if(dur.getSeconds() - time < 0){
            path = createPath(path, new Date().toString());
            time = new Date().getTime();
        }
        new FileHandler(path).print(msg);
    }
}
