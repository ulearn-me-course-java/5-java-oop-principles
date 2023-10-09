package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private static final long creationTime = System.currentTimeMillis();
    private int rotationDuration;
    private long rotationTimeUnit;

    public RotationFileHandler(int rotationDuration, ChronoUnit rotationTimeUnit) {
        setRotation(rotationDuration, rotationTimeUnit);
    }

    public int getRotationDuration() {
        return rotationDuration;
    }

    public long getRotationTimeUnit() {
        return rotationTimeUnit;
    }

    public void setRotation(int rotationDuration, ChronoUnit rotationTimeUnit) {
        this.rotationDuration = rotationDuration;
        this.rotationTimeUnit = rotationTimeUnit.getDuration().toMillis();
    }

    @Override
    public void handleMessage(String message) {
        long rotationNumber = (System.currentTimeMillis() - creationTime) / (rotationDuration * rotationTimeUnit);
        String fileName = String.format("Rotation-%d messages", rotationNumber + 1);

        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(message);
            fw.write("\n");
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
