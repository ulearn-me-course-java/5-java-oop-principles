package com.example.task04;
import java.io.*;
import java.util.ArrayList;

public class RotationFileHandler implements MessageHandler {
    private long lastCreationTime = System.currentTimeMillis();
    PrintWriter writer;
    private ArrayList<Long> listOfTimes = new ArrayList<>();
    public RotationFileHandler() {
        createLogFile();
    }
    private void createLogFile() {
        if (writer != null) {
            writer.close();
        }

        listOfTimes.add(lastCreationTime);
        FileWriter writerFile;
        try {
            writerFile = new FileWriter(lastCreationTime +" ", true);
            writer = new PrintWriter(writerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private synchronized void writeLine(String message) {

        if(listOfTimes.size()==0||listOfTimes.get(listOfTimes.size()-1) < System.currentTimeMillis() - 3600000) {
            createLogFile();
        }
        writer.println(message);
    }
        @Override
    public void print(String message) {
        writeLine(message);
    }
}
