package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.sql.Time;
import java.util.Date;

public class RotationFileHandler implements MessageHandler {
    private Path directoryPath;
    private Date startTime;
    private Time rotationTime;

    public RotationFileHandler(Path directoryPath, Time rotationTime) {
        setDirectoryPath(directoryPath);
        this.rotationTime = rotationTime;
    }

    public void setDirectoryPath(Path directoryPath) {
        startTime = new Date();
        try {
            File file = new File(directoryPath.toString());
            file.mkdir();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.directoryPath = directoryPath;
    }

    public Path getDirectoryPath() {
        return directoryPath;
    }

    public void setRotationTime(Time rotationTime) {
        this.rotationTime = rotationTime;
    }

    public Time getRotationTime() {
        return rotationTime;
    }

    @Override
    public void log(String text) {
        long iteration = (new Date().getTime() - startTime.getTime()) / rotationTime.getTime();
        try {
            FileWriter fw = new FileWriter(directoryPath.toString() + File.separator + "Log " + iteration + ".txt", true);
            fw.write(text + "\n");
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
