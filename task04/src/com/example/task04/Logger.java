package com.example.task04;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Класс Logger, который логгирует сообщения с различными уровнями важности.
 */
public class Logger {
    private final String name;
    private final String lineSeparator = System.getProperty("line.separator");
    private Level level = Level.DEBUG;
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private ArrayList<MessageHandler> handlers = new ArrayList<>();
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");

    /**
     * Уровни важности сообщений.
     */
    public static enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private Logger(String name) {
        this.name = name;
        loggers.put(name, this);
        this.handlers.add(new ConsoleHandler());
    }

    /**
     * Получение имени логгера.
     *
     * @return имя логгера
     */
    public String getName() {
        return name;
    }


    /**
     * Возвращает логгер из списка логгеров либо создает и возвращает логгер, если его ещё не существует
     *
     * @param name имя логгера
     * @return логгер
     */
    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        if (logger == null) {
            logger = new Logger(name);
        }
        return logger;
    }

    /**
     * Получение текущего уровня важности сообщений, сообщения с уровнем ниже данного не обрабатываются.
     *
     * @return уровень важности
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Установка уровня важности сообщений, сообщения с уровнем ниже этого обрабатываться не будут.
     *
     * @param level добавляемый обработчик
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Добавление обработчика в список обработчиков данного логгера.
     *
     * @param handler добавляемый обработчик
     */
    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    /**
     * Отправить сообщение уровня важности ERROR в обработчик(и).
     *
     * @param msg текст сообщения
     */
    public void error(String msg) throws IOException {
        log(Level.ERROR, msg);
    }

    /**
     * Отправить сообщение уровня важности ERROR в обработчик(и).
     *
     * @param format  формат сообщения
     * @param varargs параметры для формата
     */
    public void error(String format, Object... varargs) throws IOException {
        log(Level.ERROR, String.format(format, varargs));
    }

    /**
     * Отправить сообщение уровня важности WARNING в обработчик(и).
     *
     * @param msg текст сообщения
     */
    public void warning(String msg) throws IOException {
        log(Level.WARNING, msg);
    }

    /**
     * Отправить сообщение уровня важности WARNING в обработчик(и).
     *
     * @param format  формат сообщения
     * @param varargs параметры для формата
     */
    public void warning(String format, Object... varargs) throws IOException {
        log(Level.WARNING, String.format(format, varargs));
    }

    /**
     * Отправить сообщение уровня важности INFO в обработчик(и).
     *
     * @param msg текст сообщения
     */
    public void info(String msg) throws IOException {
        log(Level.INFO, msg);
    }

    /**
     * Отправить сообщение уровня важности INFO в обработчик(и).
     *
     * @param format  формат сообщения
     * @param varargs параметры для формата
     */
    public void info(String format, Object... varargs) throws IOException {
        log(Level.INFO, String.format(format, varargs));
    }

    /**
     * Отправить сообщение уровня важности DEBUG в обработчик(и).
     *
     * @param msg текст сообщения
     */
    public void debug(String msg) throws IOException {
        log(Level.DEBUG, msg);
    }

    /**
     * Отправить сообщение уровня важности DEBUG в обработчик(и).
     *
     * @param format  формат сообщения
     * @param varargs параметры для формата
     */
    public void debug(String format, Object... varargs) throws IOException {
        log(Level.DEBUG, String.format(format, varargs));
    }

    /**
     * Отправить сообщение в обработчик(и).
     *
     * @param message текст сообщения
     */
    public void log(Level level, String message) throws IOException {
        if (level.ordinal() >= this.level.ordinal()) {
            String dateNow = LocalDateTime.now().format(dateFormat);
            for (MessageHandler handler : handlers) {
                handler.printMessage(String.format("[%s] %s %s - %s%s", level, dateNow, name, message, lineSeparator));
            }
        }
    }

    /**
     * Отправить сообщение в обработчик(и).
     *
     * @param level   уровень важности
     * @param format  формат сообщения
     * @param varargs параметры для формата
     */
    public void log(Level level, String format, Object... varargs) throws IOException {
        log(level, String.format(format, varargs));
    }

}