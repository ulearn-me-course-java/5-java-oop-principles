package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Time;
import java.util.Date;

public class RotationFileHandler implements MessageHandler {

    private static final String FILE_NAME = "Log_";
    private Path directoryPath;
    private Date startTime;
    private final Time rotationTime;

    /**
     * @param directoryPath Путь до директории, где будут храниться файлы. Если директория уже существует, то она будет удалена!
     * @param rotationTime  Интервал времени, который должен пройти для создания нового файла
     */
    public RotationFileHandler(Path directoryPath, Time rotationTime) {
        setDirectoryPath(directoryPath);
        this.rotationTime = rotationTime;
    }

    /**
     * @return Интервал времени, который должен пройти для создания нового файла
     */
    public Time getRotationTime() {
        return rotationTime;
    }

    /**
     * Задаёт директорию, где будут храниться файлы с логами
     *
     * @param directoryPath Путь до директории, где будут храниться файлы. Если директория уже существует, то она будет удалена!
     */
    public void setDirectoryPath(Path directoryPath) {
        startTime = new Date();
        try {
            if (Files.exists(directoryPath)) {
                File[] contents = directoryPath.toFile().listFiles();
                if (contents != null) {
                    for (File f : contents) {
                        f.delete();
                    }
                }
                Files.delete(directoryPath);
            }

            Files.createDirectory(directoryPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.directoryPath = directoryPath;
    }

    /**
     * Возвращает путь до директории, где содержатся файлы с логами
     */
    public Path getDirectoryPath() {
        return directoryPath;
    }

    @Override
    public void logMessage(String message) {
        {
            long ts = (new Date()).getTime() - startTime.getTime();
            long iteration = ts / rotationTime.getTime();
            try {
                FileWriter fw = new FileWriter(directoryPath.toString() + "\\" + FILE_NAME + iteration, true);
                fw.write(message + "\n");
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
