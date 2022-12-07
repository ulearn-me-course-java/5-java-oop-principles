package com.example.task04;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler implements MessageHandler {
    private Path filePath;

    /**
     * @param path Путь до файла (включая имя файла). Если файл существует, то он удалится!
     */
    public FileHandler(Path path) {
        setFilePath(path);
    }

    /**
     * Задаёт путь для сохранения логов
     *
     * @param path Путь до файла (включая имя файла). Если файл существует, то он удалится!
     */
    public void setFilePath(Path path) {
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }

            Files.createFile(path);
            this.filePath = path;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает путь до файла, куда сохраняются логи
     */
    public Path getFilePath() {
        return filePath;
    }

    @Override
    public void logMessage(String message) {
        try {
            FileWriter fw = new FileWriter(filePath.toFile(), true);
            fw.write(message + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
