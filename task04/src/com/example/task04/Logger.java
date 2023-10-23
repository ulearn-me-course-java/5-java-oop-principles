package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logger {

    private final String name;
    private LogLevel logLevel = LogLevel.DEBUG;
    private final List<MessageHandler> loggers = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        this.logLevel = LogLevel.INFO;
        loggers.add(new ConsoleHandler());
    }

    public Logger(String name, MessageHandler... handlers) {
        this.name = name;
        this.logLevel = LogLevel.INFO;
        loggers.addAll(Arrays.asList(handlers));
    }

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.logLevel = level;
        loggers.add(new ConsoleHandler());
    }

    public String getName() {
        return name;
    }
    public static Logger getLogger(String name) {
        return new Logger(name);
    }
    public void setLevel(LogLevel level) {
        this.logLevel = level;
    }

    public LogLevel getLevel() {
        return logLevel;
    }
    public void  log(LogLevel level, String message) {
        if (level.ordinal() >= this.logLevel.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }    }

    public void log(LogLevel level, String template, Object... args) {
        if (level.ordinal() >= this.logLevel.ordinal()) {
            System.out.println(MessageFormat.format(template, args));
        }
    }
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String template, Object... args) {
        log(LogLevel.INFO, template, args);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(LogLevel.DEBUG, template, args);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(LogLevel.WARNING, template, args);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(LogLevel.ERROR, template, args);
    }
}