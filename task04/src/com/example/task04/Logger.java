package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logger {
    private final String name;
    private Level level;
    private final List<MessageHandler> loggerList = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        this.level = Level.INFO;
        loggerList.add(new ConsoleHandler());
    }

    public Logger(String name, MessageHandler... handlers) {
        this.name = name;
        this.level = Level.INFO;
        loggerList.addAll(Arrays.asList(handlers));
    }

    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggerList.add(new ConsoleHandler());
    }

    public String getName() {
        return name;
    }
    public static Logger getLogger(String name) {
        return new Logger(name);
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
    public void  log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }    }

    public void log(Level level, String template, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(template, args));
        }
    }
    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String template, Object... args) {
        log(Level.INFO, template, args);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        log(Level.DEBUG, template, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String template, Object... args) {
        log(Level.WARNING, template, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String template, Object... args) {
        log(Level.ERROR, template, args);
    }
}
