package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import lombok.NonNull;

/**
 * Класс реализует логгирование сообщений с различными уровнями важности (уровнями логгирования).
 */
public class Logger {

    private final String name;
    private Level level;
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    /**
     * По умолчанию логгер создается с самым высоким уровнем важности - ERROR
     *
     * @param name
     */
    private Logger(String name) {
        this.name = name;
        this.level = Level.ERROR;
    }

    /**
     * Метод возвращает экземпляр логгера с указанным именем.
     * Повторый вызов с тем же аргументом должен возвращать тот же самый экземпляр, что и при первом вызове.
     * Если логгер с указанным именем существует, то возвращается логгер соответсвующий имени,
     * иначе создается и возвращается новый логгер.
     *
     * @param name
     * @return
     */
    public static Logger getLogger(@NonNull String name) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        } else {
            Logger logger = new Logger(name);
            loggers.put(logger.name, logger);
            return logger;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    /**
     * Метод логгирует сообщение (выводит в консоль) message с указанным уровнем level.
     * Сообщения с уровнем логгирования ниже установленного не печатаются в консоль.
     *
     * @param message - сообщение
     * @param level   - уровень логгирования
     */
    public void log(@NonNull String message, @NonNull Level level) {
        if (this.level.compareTo(level) >= 0) {
            System.out.println("[" + level + "] " + dateFormat.format(new Date()) + " " + name + " - " + message);
        }
    }

    /**
     * Метод логгирует сообщение (выводит в консоль) с указанным шаблоном,
     * подставляя в него переменное число аргументов и учитывая указанный уровень логгирования.
     * Сообщения с уровнем логгирования ниже установленного не печатаются в консоль.
     *
     * @param template - шаблон сообщения
     * @param level    - уровень логгирования
     * @param objects  - переменное число аргументов, подставляемых в шаблон
     */
    public void log(@NonNull String template, @NonNull Level level, @NonNull Object... objects) {
        if (this.level.compareTo(level) >= 0) {
            String message = String.format(template, objects);
            this.log(message, level);
        }
    }

    public void debug(@NonNull String message) {
        log(message, Level.DEBUG);
    }

    public void debug(@NonNull String template, @NonNull Object... objects) {
        log(template, Level.DEBUG, objects);
    }

    public void info(@NonNull String message) {
        log(message, Level.INFO);
    }

    public void info(@NonNull String template, @NonNull Object... objects) {
        log(template, Level.INFO, objects);
    }

    public void warning(@NonNull String message) {
        log(message, Level.WARNING);
    }

    public void warning(@NonNull String template, @NonNull Object... objects) {
        log(template, Level.WARNING, objects);
    }

    public void error(@NonNull String message) {
        log(message, Level.ERROR);
    }

    public void error(@NonNull String template, @NonNull Object... objects) {
        log(template, Level.ERROR, objects);
    }
}
