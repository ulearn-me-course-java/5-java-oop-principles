package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logger {
    private final String name;
    private LoggerLevel level;
    private final List<MessageHandler> loggerList = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        this.level = LoggerLevel.INFO;
        loggerList.add(new ConsoleHandler());
    }

    public Logger(String name, MessageHandler... handlers) {
        this.name = name;
        this.level = LoggerLevel.INFO;
        loggerList.addAll(Arrays.asList(handlers));
    }

    public Logger(String name, LoggerLevel level) {
        this.name = name;
        this.level = level;
        loggerList.add(new ConsoleHandler());
    }

    public LoggerLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public void setLevel(LoggerLevel level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        return new Logger(name);
    }

    public void info(String message) {
        log(LoggerLevel.INFO, message);
    }

    public void info(String template, Object... args) {
        log(LoggerLevel.INFO, template, args);
    }

    public void debug(String message) {
        log(LoggerLevel.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(LoggerLevel.DEBUG, template, args);
    }

    public void warning(String message) {
        log(LoggerLevel.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(LoggerLevel.WARNING, template, args);
    }

    public void error(String message) {
        log(LoggerLevel.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(LoggerLevel.ERROR, template, args);
    }

    public void log(LoggerLevel level, String message) {
        printMessage(level, message);
    }

    public void log(LoggerLevel level, String template, Object... args) {
        printMessage(level, template, args);
    }

    private void printMessage(LoggerLevel level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {

            String logMessage = MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message);
            for (MessageHandler mh : loggerList){
                mh.log(logMessage);
            }
        }
    }
    private void printMessage(LoggerLevel level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            String logMessage =MessageFormat.format(template, args);
            for (MessageHandler mh : loggerList){
                mh.log(logMessage);
            }
        }
    }
}
