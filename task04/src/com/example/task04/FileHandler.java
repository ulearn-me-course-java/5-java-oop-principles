package com.example.task04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler implements MessageHandler{
    private Path filePath;
    private MyLogger myLogger;

    public FileHandler(String filePath){
        this.myLogger = MyLogger.getLogger("FileHandlerLogger");
        this.filePath = Paths.get(filePath);
    }

    @Override
    public void log(Level level, String string) {
        myLogger.log(level, string);
        String text = myLogger.getLogs().get(myLogger.getLogs().size() - 1).toString();
        try {
            if(!Files.exists(filePath))
                Files.createFile(filePath);
            Files.write(filePath, text.getBytes(), StandardOpenOption.APPEND);

        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
