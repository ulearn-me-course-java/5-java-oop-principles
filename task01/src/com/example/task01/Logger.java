package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    private String name;
    private Level level;
    private static ArrayList<Logger> loggers = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
    }
    public  Logger() {}

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        Logger newLogger = new Logger();
        for (Logger logger : loggers) {
            if (logger.name.equals(name)) {
                newLogger = logger;
            }
        }
        return newLogger;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public void debug(String message) {
        log(this.level, message);
    }

    public void debug(String format, Object... arguments) {
        log(this.level, format, arguments);
    }

    public void info(String message) {
        log(this.level, message);
    }

    public void info(String format, Object... arguments) {
        log(this.level, format, arguments);
    }

    public void warning(String message) {
        log(this.level, message);
    }

    public void warning(String format, Object... arguments) {
        log(this.level, format, arguments);
    }

    public void error(String message) {
        log(this.level, message);
    }

    public void error(String format, Object... arguments) {
        log(this.level, format, arguments);
    }

    public void log(Level level, String message) {
        printMessage(level, message);
    }

    public void log(Level level, String format, Object... arguments) {
        printMessage(level, format, arguments);
    }

    public void printMessage(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} {3}",
                    level,
                    LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }

    public void printMessage(Level level, String format, Object... arguments) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(format, arguments));
        }
    }
}
