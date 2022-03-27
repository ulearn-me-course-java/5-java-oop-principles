package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {
    private final static ArrayList<Logger> LOGGERS = new ArrayList<>();
    //hashmap
    private final String name;
    private ImportanceLevel level;

    public Logger(String name, ImportanceLevel level) {
        this.name = name;
        setLevel(level);
        LOGGERS.add(this);
    }

    public Logger(String name) {
        this(name, ImportanceLevel.DEBUG);
    }

    public String getName() {
        return name;
    }

    public ImportanceLevel getLevel() {
        return level;
    }

    public void setLevel(ImportanceLevel level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        for (Logger logger : LOGGERS) {
            if(logger.getName().equals(name)) return logger;
        }
        return new Logger(name);
    }

    public void log(ImportanceLevel level, String message) {
        if(level.ordinal() >= this.level.ordinal()) {
            //2018.07.17 09:56:32
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                    name,
                    message));
        }
    }

    public void log(ImportanceLevel level, String messageFormat, Object... args) {
        log(level, new MessageFormat(messageFormat).format(args));
    }

    public void debug(String message) {
        log(ImportanceLevel.DEBUG, message);
    }

    public void debug(String messageFormat, Object... args) {
        log(ImportanceLevel.DEBUG, messageFormat, args);
    }

    public void info(String message) {
        log(ImportanceLevel.INFO, message);
    }

    public void info(String messageFormat, Object... args) {
        log(ImportanceLevel.INFO, messageFormat, args);
    }

    public void warning(String message) {
        log(ImportanceLevel.WARNING, message);
    }

    public void warning(String messageFormat, Object... args) {
        log(ImportanceLevel.WARNING, messageFormat, args);
    }

    public void error(String message) {
        log(ImportanceLevel.ERROR, message);
    }

    public void error(String messageFormat, Object... args) {
        log(ImportanceLevel.ERROR, messageFormat, args);
    }
}
