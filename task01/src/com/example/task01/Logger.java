package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует логгирование сообщений с различными уровнями важности (уровнями логгирования).
 */
public class Logger {
    private final static Map<String, Logger> loggerInstances = new HashMap<>();
    private static SimpleDateFormat formatter = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
    private final String name;
    private String minimalLevel = "DEBUG";

    private Logger(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает экземпляр логгера с указанным именем.
     * Повторый вызов с тем же аргументом должен возвращать тот же самый экземпляр, что и при первом вызове.
     * Если логгер с указанным именем существует, то возвращается логгер соответсвующий имени,
     * иначе создается и возвращается новый логгер.
     *
     * @param name
     * @return экземпляр логгера
     */
    public static Logger getLogger(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name must be not null");
        }
        Logger out = loggerInstances.get(name);
        if (out == null) {
            out = new Logger(name);
            loggerInstances.put(name, out);
        }
        return out;
    }

    private static void printMessage(String level, String name, String message) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(String.format("[%s] %s %s - %s", level, formatter.format(date), name, message));
    }

    public String getName() {
        return this.name;
    }

    public String getLevel() {
        return minimalLevel;
    }

    public void setLevel(String level) {
        if (level == null) {
            throw new IllegalArgumentException("Level must be not null");
        }
        switch (level) {
            case "ERROR":
            case "INFO":
            case "DEBUG":
            case "WARNING":
                minimalLevel = level;
                break;
            default:
                throw new IllegalArgumentException("Level must be ERROR | INFO | DEBUG | WARNING");
        }
    }

    private boolean canLog(String level) {
        if (minimalLevel.equals("INFO") && level.equals("DEBUG"))
            return false;
        if (minimalLevel.equals("WARNING") && (level.equals("DEBUG") || level.equals("INFO")))
            return false;
        return !minimalLevel.equals("ERROR") || (!level.equals("DEBUG") && !level.equals("INFO") && !level.equals("WARNING"));
    }

    /**
     * Метод логгирует сообщение (выводит в консоль) message с указанным уровнем level.
     * Сообщения с уровнем логгирования ниже установленного не печатаются в консоль.
     *
     * @param level   - уровень логгирования
     * @param message - сообщение
     */
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

    /**
     * Метод логгирует сообщение (выводит в консоль) с указанным шаблоном,
     * подставляя в него переменное число аргументов и учитывая указанный уровень логгирования.
     * Сообщения с уровнем логгирования ниже установленного не печатаются в консоль.
     *
     * @param template - шаблон сообщения
     * @param level    - уровень логгирования
     * @param args  - переменное число аргументов, подставляемых в шаблон
     */
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
        if (!canLog(level))
            return;
        printMessage(level, this.name, message);
    }

    public void error(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String level = "ERROR";
        if (!canLog(level))
            return;
        String message = String.format(template, args);
        printMessage(level, this.name, message);
    }

    public void info(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must be not null");
        }
        String level = "INFO";
        if (!canLog(level))
            return;
        printMessage(level, this.name, message);
    }

    public void info(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String level = "INFO";
        if (!canLog(level))
            return;
        String message = String.format(template, args);
        printMessage(level, this.name, message);
    }

    public void warning(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must be not null");
        }
        String level = "WARNING";
        if (!canLog(level))
            return;
        printMessage(level, this.name, message);
    }

    public void warning(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String level = "WARNING";
        if (!canLog(level))
            return;
        String message = String.format(template, args);
        printMessage(level, this.name, message);
    }

    public void debug(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must be not null");
        }
        String level = "DEBUG";
        if (!canLog(level))
            return;
        printMessage(level, this.name, message);
    }

    public void debug(String template, Object... args) {
        if (template == null) {
            throw new IllegalArgumentException("Template must be not null");
        }
        String level = "DEBUG";
        if (!canLog(level))
            return;
        String message = String.format(template, args);
        printMessage(level, this.name, message);
    }
}
