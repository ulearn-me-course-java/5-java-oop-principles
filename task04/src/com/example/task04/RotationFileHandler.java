package com.example.task04;

import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private ChronoUnit chronoUnit;

    public RotationFileHandler(ChronoUnit chronoUnit) {
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void processMessage(String currentName, LogSeverityLvl lvl, String message) {

    }

    @Override
    public void processMessage(String format, Object... params) {

    }
}
