package com.example.task04;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Logger {
    private Level level;

    enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR;
    }

    private String name;
    private static ArrayList<Logger> logs = new ArrayList<>();
    private MessageHandler[] messageHandlers;


    public static Logger getLogger(String name) {
        for (Logger logger : logs) if (logger.name == name) return logger;

        Logger l = new Logger(name);
        logs.add(l);
        return l;
    }

    public Logger(String name) {
        this.name = name;
        logs.add(this);
        messageHandlers = new MessageHandler[4];
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


    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Logger) {
            Logger logger = (Logger) obj;
            return logger.name == this.name;
        }
        return false;
    }

    private String getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return (formatter.format(calendar.getTime()));
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String format, Object... elements) {
        log(Level.ERROR, format, elements);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String format, Object... elements) {
        log(Level.INFO, format, elements);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String format, Object... elements) {
        log(Level.WARNING, format, elements);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String format, Object... elements) {
        log(Level.DEBUG, format, elements);
    }

    private void log(Level level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            String result = String.format("[%s] %s %s - %s", level.name(), getTime(), name, message);
            for (MessageHandler ms : messageHandlers) {
                if (ms != null) {

                    ms.write(result);
                }
            }
        }

    }

    private void log(Level level, String formatOfMessage, Object elements) {
        if (this.level.ordinal() <= level.ordinal()) {
            MessageFormat form = new MessageFormat(formatOfMessage);
            for (MessageHandler messageHandler:
                    messageHandlers) {
                if (messageHandler!=null){
                    messageHandler.write(form.format(elements));
                }
            }
        }
    }
}
