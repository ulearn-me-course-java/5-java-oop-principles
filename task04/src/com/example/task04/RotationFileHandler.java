package com.example.task04;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RotationFileHandler implements MessageHandler{

    private FileHandler fileHandler;
    private final int rotationSeconds;
    private Date lastTimeLog;
    private String path;




    public RotationFileHandler( String dirPath, int sec){
        rotationSeconds = sec;
        fileHandler = new FileHandler(dirPath);
        path = dirPath;
    }


    @Override
    public void log(String message) {
        if( lastTimeLog==null || (new Date().getTime() - lastTimeLog.getTime())/1000 > rotationSeconds ){

            lastTimeLog = new Date();
            fileHandler = new FileHandler(path) ;
            fileHandler.log(message);
        }
        else {
            fileHandler.log(message);
        }
    }
}
