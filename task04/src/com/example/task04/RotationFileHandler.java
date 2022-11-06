package com.example.task04;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class RotationFileHandler implements MessageHandler{

    private String filePath;

    private ChronoUnit rotation;

    public RotationFileHandler(String name, ChronoUnit rotation) {
        this.filePath = name;
        this.rotation = rotation;
    }
    RotationFileHandler(){
        filePath = "message rotation";
        rotation = ChronoUnit.HOURS;
    }
    public void setFilePath(String path){
        this.filePath = path;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setRotation(ChronoUnit rotation){
        this.rotation = rotation;
    }
    public String getRotation(){
        return rotation.toString();
    }
    public void log(String message) {
        LocalDateTime date = LocalDateTime.now().truncatedTo(rotation);
        String file = filePath + " " + date.toString().replace(':', ' ') + ".txt";
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.append(message);
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
