package com.example.task04;

public class ConsoleHandler implements MessageHandler{

    @Override
    public void publish(RecordLog recordLog) {
        System.out.println(recordLog.getLogMessage());
    }
}
