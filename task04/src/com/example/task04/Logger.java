package com.example.task04;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private String name;
    private ImportanceLevel level = ImportanceLevel.DEBUG;
    private MessageHandler[] messageHandlers;
    private static HashMap<String, Logger> loggerList = new HashMap<String, Logger>();

    public Logger(String name) {
        this.name = name;
        messageHandlers = new MessageHandler[4];
        loggerList.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String newName) {

        if (loggerList.containsKey(newName)) {
            return loggerList.get(newName);
        }
        return new Logger(newName);
    }

    private void log(ImportanceLevel level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            String log = String.format("[%s] %s %s - %s", level.name(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")), name, message);
            for (MessageHandler messageHandler :
                    messageHandlers) {
                if (messageHandler != null) {
                    messageHandler.writeMessage(log);
                }
            }
        }

    }

    private void log(ImportanceLevel level, String messageFormat, Object... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            String log = String.format(messageFormat, args);
            for (MessageHandler messageHandler :
                    messageHandlers) {
                if (messageHandler != null) {
                    messageHandler.writeMessage(log);
                }
            }
        }
    }

    public void AddHandler(MessageHandler messageHandler) {
        if (messageHandler instanceof ConsoleHandler) {
            messageHandlers[0] = messageHandler;
        } else if (messageHandler instanceof FileHandler) {
            messageHandlers[1] = messageHandler;
        } else if (messageHandler instanceof RotationFileHandler) {
            messageHandlers[2] = messageHandler;
        } else if (messageHandler instanceof MemoryHandler) {
            messageHandlers[3] = messageHandler;
        }
    }

    public void RemoveHandler(MessageHandler messageHandler) {
        if (messageHandler instanceof ConsoleHandler) {
            messageHandlers[0] = null;
        } else if (messageHandler instanceof FileHandler) {
            messageHandlers[1] = null;
        } else if (messageHandler instanceof RotationFileHandler) {
            messageHandlers[2] = null;
        } else if (messageHandler instanceof MemoryHandler) {
            messageHandlers[3] = null;
        }
    }

    public void setLevel(ImportanceLevel level) {
        this.level = level;
    }

    public ImportanceLevel getLevel() {
        return level;
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

