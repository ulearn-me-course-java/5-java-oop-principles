package com.example.task04;

import java.sql.Time;
import java.util.Date;

public class RotationLogger implements ILogger {
    @Override
    public void log(String message){
        Date date = new Date();
        String fileName = Integer.toString(date.getHours());

        ILogger fileLogger = new FileLogger(fileName);
    }
}
