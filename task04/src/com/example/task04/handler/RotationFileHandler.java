package com.example.task04.handler;

import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler  implements MessageHandler {
    private static final long creationTime = System.currentTimeMillis();
    private int rotationDuration;

    public int getRotationDuration() {
        return rotationDuration;
    }

    private long rotationTimeUnit;

    public long getRotationTimeUnit() {
        return rotationTimeUnit;
    }

    public RotationFileHandler(int rotationDuration, ChronoUnit rotationTimeUnit) {
        this.rotationDuration = rotationDuration;
        this.rotationTimeUnit = rotationTimeUnit.getDuration().toMillis();
    }

    public void setRotation(int rotationDuration, ChronoUnit rotationTimeUnit) {
        this.rotationDuration = rotationDuration;
        this.rotationTimeUnit = rotationTimeUnit.getDuration().toMillis();
    }

    @Override
    public void handleMessage(String message) {
        long rotationNumber = (System.currentTimeMillis() - creationTime)
                / (rotationDuration * rotationTimeUnit);
        String fileName = String.format("Rotation №%d logs", rotationNumber + 1L);
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(message);
            writer.write("\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
