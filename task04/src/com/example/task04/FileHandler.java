package com.example.task04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler implements MessageHandler{
    private Path filePath;
    private Logger logger;

    public FileHandler(String filePath){
        this.logger = Logger.getLogger("FileHandlerLogger");
        this.filePath = Paths.get(filePath);
    }

    @Override
    public void log(Level level, String string) {
        logger.log(level, string);
        String text = logger.getLogs().get(logger.getLogs().size() - 1).toString();
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
