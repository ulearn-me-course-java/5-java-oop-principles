package com.example.task04;

import jdk.jfr.Period;
import jdk.jfr.Timespan;

import java.io.File;
import java.util.Date;

public class RotationFileHandler implements MessageHandler{

    private Logger logger;
    private long timeSpan;
    private Date lastWrite;
    private String path;


    public RotationFileHandler(){
        this.logger = Logger.getLogger("RotationHandlerLogger");
        timeSpan = 1000 * 60 * 60;
        lastWrite = new Date();
        path = lastWrite.toString();
    }

    @Override
    public void log(Level level, String string) {
        Date d = new Date();
        if (d.getTime() - lastWrite.getTime() > timeSpan) {
            path = new Date().toString();
        }
        new FileHandler(path.replace(":", "_") + ".txt").log(level, string);
    }

    public void setInterval(long fromMilliseconds) {
        timeSpan = fromMilliseconds;
    }
}
