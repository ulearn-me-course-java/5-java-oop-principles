package com.example.task01;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private String name;
    private static String minimalLevel = "DEBUG";
    private static Map<String, Logger> LoggerInstances = new HashMap<>();

    public static Logger getLogger(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name must be not null");
        }
        Logger out = LoggerInstances.get(name);
        if (out == null) {
            out = new Logger(name);
            LoggerInstances.put(name, out);
        }
        return out;
    }

    public String getName() {
        return this.name;
    }

    public static String getLevel() {
        return new String(minimalLevel);
    }

    public static void setLevel(String level) {
        if (level == null) {
            throw new IllegalArgumentException("Level must be not null");
        }
        switch (level) {
            case "ERROR":
            case "INFO":
            case "DEBUG":
            case "WARNING":
                minimalLevel = new String(level);
                break;
            default:
                throw new IllegalArgumentException("Level must be ERROR | INFO | DEBUG | WARNING");
        }
    }


    public void log(String level, String message) {
        if (level == null || message == null) {
            throw new IllegalArgumentException("Arguments must be not null");
        }
        switch (level) {
            case "ERROR":
                error(message);
                break;
            case "INFO":
                info(message);
                break;
            case "DEBUG":
                debug(message);
                break;
            case "WARNING":
                warning(message);
                break;
            default:
                throw new IllegalArgumentException("Level must be ERROR | INFO | DEBUG | WARNING");
        }
    }

    public void log(String level, String template, Object... args) {
        if (level == null || template == null) {
            throw new IllegalArgumentException("Arguments must be not null");
        }
        switch (level) {
            case "ERROR":
                error(template, args);
                break;
            case "INFO":
                info(template, args);
                break;
            case "DEBUG":
                debug(template, args);
                break;
            case "WARNING":
                warning(template, args);
                break;
            default:
                throw new IllegalArgumentException("Level must be ERROR | INFO | DEBUG | WARNING");
        }
    }

    public void error(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must be not null");
        }
        String level = "ERROR";
        printMessage(level, this.name, message);
    }

    public void error(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String message = String.format(template, args);
        String level = "ERROR";
        printMessage(level, this.name, message);
    }

    public void info(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must be not null");
        }
        String level = "INFO";
        printMessage(level, this.name, message);
    }

    public void info(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String message = String.format(template, args);
        String level = "INFO";
        printMessage(level, this.name, message);
    }

    public void warning(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must be not null");
        }
        String level = "WARNING";
        printMessage(level, this.name, message);
    }

    public void warning(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String message = String.format(template, args);
        String level = "WARNING";
        printMessage(level, this.name, message);
    }

    public void debug(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must be not null");
        }
        String level = "DEBUG";
        printMessage(level, this.name, message);
    }

    public void debug(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String message = String.format(template, args);
        String level = "DEBUG";
        printMessage(level, this.name, message);
    }

    private static void printMessage(String level, String name, String message) {
        if (minimalLevel.equals("INFO") && level.equals("DEBUG"))
            return;
        if (minimalLevel.equals("WARNING") && (level.equals("DEBUG") || level.equals("INFO")))
            return;
        if (minimalLevel.equals("ERROR") && (level.equals("DEBUG") || level.equals("INFO") || level.equals("WARNING")))
            return;
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(String.format("[%s] %s %s - %s", level, formatter.format(date), name, message));
    }

    private Logger() {
    }

    private Logger(String name) {
        this.name = name;
    }
}
