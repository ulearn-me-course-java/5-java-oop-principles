package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private ArrayList<RecordLog> recordLogs;
    public MemoryHandler(){
        recordLogs = new ArrayList<>();
    }
    public ArrayList<RecordLog> getRecordLogs(){
        return recordLogs;
    }
    @Override
    public void publish(RecordLog recordLog) {
        recordLogs.add(recordLog);
    }
    public void unloadConsole(int countLog){
        for (RecordLog item: recordLogs) {
            if (countLog == 0){
                return;
            }
            System.out.println(item.getLogMessage());
            countLog--;
        }
    }
    public void unloadConsole(){
        for (RecordLog item: recordLogs) {
            System.out.println(item.getLogMessage());
        }
    }
    public void unloadFile(String pathName, int countLog){
        try(FileWriter writer = new FileWriter(pathName + ".txt", true))
        {
            for (RecordLog item: recordLogs) {
                if (countLog == 0){
                    return;
                }
                recordLogs.remove(item);
                String text = item.getLogMessage();
                writer.write(text + "\n");
                countLog--;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void unloadFile(String pathName){
        try(FileWriter writer = new FileWriter(pathName + ".txt", true))
        {
            for (RecordLog item: recordLogs) {
                String text = item.getLogMessage();
                writer.write(text + "\n");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void clear(){
        recordLogs = new ArrayList<>();
    }
}
