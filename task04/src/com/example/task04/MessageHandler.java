package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

interface MessageHandler {
    void log(String message);
}
class ConsoleHandler implements MessageHandler{

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
class FileHandler implements MessageHandler{

    @Override
    public void log(String message){

        try {
            FileWriter fileWriter = new FileWriter("D:/proga/java/5-java-oop-principles/task04/src/log.txt", true);
            fileWriter.append(message);
            fileWriter.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class RotationFileHandler implements MessageHandler{

    private final ChronoUnit rotation;
    public RotationFileHandler(ChronoUnit rotation){
        this.rotation = rotation;
    }
    @Override
    public void log(String message){
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);

        try {
            FileWriter fileWriter = new FileWriter("D:/proga/java/5-java-oop-principles/task04/src/logs/log_" + now.toString().replace(':', '_') + ".txt", true);
            fileWriter.append(message);
            fileWriter.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class MemoryHandler implements MessageHandler{

    private ArrayList<MessageHandler> messageHandlers = new ArrayList<>();
    private ArrayList<String> buffer = new ArrayList<>();
    private int bufferSize;

    public MemoryHandler(int bufferSize, MessageHandler... handlers){
        this.bufferSize = bufferSize;
        messageHandlers.addAll(Arrays.asList(handlers));
    }

    @Override
    public void log(String message){
        buffer.add(message);
        if (buffer.size() == bufferSize) {
            logBuffer();
        }
    }

    public void logBuffer(){
        for (MessageHandler handler : messageHandlers){
            for (String msg : buffer){
                handler.log(msg);
            }
        }
        buffer.clear();
    }
}