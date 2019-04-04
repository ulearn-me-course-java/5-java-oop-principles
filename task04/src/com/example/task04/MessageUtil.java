package com.example.task04;

enum MessageLevel
{
    DEBUG, INFO, WARNING, ERROR;
}

public class MessageUtil {

    private static MessageLevel[] levels = {
            MessageLevel.DEBUG,
            MessageLevel.INFO,
            MessageLevel.WARNING,
            MessageLevel.ERROR
    };
    private static String[] msgLevelNames = {
            "DEBUG",
            "INFO",
            "WARNING",
            "ERROR"
    };


    public static int GetValue(MessageLevel msgLevel) {

        for(int i = 0; i < levels.length; i++) {
            if (levels[i] == msgLevel)
                return i;
        }

        throw new IndexOutOfBoundsException();
    }

    public static String toString(MessageLevel level){

        return msgLevelNames[GetValue(level)];
    }
}
