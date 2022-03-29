package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *  обработчик, выводящий сообщения в файл с определенной ротацией
 *  например, для каждого часа создается свой файл.
 *  Для данного обработчика нужно иметь возможность выставлять интервал ротации
 *  (например, с помощью java.time.temporal.ChronoUnit, либо другим удобным способом).
 */
public class RotationFileHandler implements MessageHandler {

    private ChronoUnit interval;

    public RotationFileHandler(ChronoUnit unit) { interval = unit; }

    @Override
    public void log(String message) {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(interval);
        String fileName = String.format("log_%s.txt", currentTime.toString().replace(':', '_'));
        String path = String.format("task04\\src\\rotations\\%s", fileName);
        try (FileWriter fileWriter = new FileWriter(path, true)){
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e){
            e.printStackTrace();;
            System.out.println("Error in RotationFileHandler");
        }
    }

}
