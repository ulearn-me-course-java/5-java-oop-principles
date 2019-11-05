package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import lombok.NonNull;

public class Logger {
    private String name;
    private Level level;
    private static List<Logger> loggers = new ArrayList<Logger>();

    public Logger(@NonNull String name) {
        this.name = name;
        loggers.add(this);
    }

    public String getName() {
        return this.name;
    }

    /**
     * Возвращает экземпляр логгера с указанным именем.
     * Повторый вызов с тем же аргументом должен возвращать тот же самый экземпляр, что и при первом вызове.
     * Если логгер с указанным именем содержится в списке логгеров, то возвращается логгер соответсвующий имени.
     * Иначе, если логгера с указанным именем нет в списке, создается и возвращается новый эеземпляр логгера.
     *
     * @param name
     * @return
     */
    public static Logger getLogger(@NonNull String name) {
        for (Logger l : loggers) {
            if (l.getName().equals(name)) {
                return l;
            }
        }
        return new Logger(name);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public void log(@NonNull String message, @NonNull Level level) {
        if (this.level == null) {
            this.level = level;
        }
        if (this.level.compareTo(level) >= 0) {
            log(message, this.level, (Object) null);
        }
    }

    public void log(@NonNull String template, @NonNull Level level, @NonNull Object... objects) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        if (this.level != null && this.level.compareTo(level) >= 0)
            System.out.println("[" + level + "] "
                    + dateFormat.format(new Date())
                    + " " + name + " - "
                    + String.format(template, objects));
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
