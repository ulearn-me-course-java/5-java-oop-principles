package com.example.task04;

public class ConsoleLogger implements ILogger{
    @Override
    public void log(String message){
        System.out.println(message);
    }
}
