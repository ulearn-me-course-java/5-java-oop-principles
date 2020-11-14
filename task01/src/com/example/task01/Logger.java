package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.*;

public class Logger
{
    private final String name;
    private String level = "DEBUG";
    private static ArrayList<Logger> loggers = new ArrayList<>();
    private static final HashMap<String, Integer> levels;

    static
    {
        levels = new HashMap<>();
        levels.put("DEBUG", 1);
        levels.put("INFO", 2);
        levels.put("WARNING", 3);
        levels.put("ERROR", 4);
    }

    public Logger(String name)
    {
        this.name = name;
        loggers.add(this);
    }

    public String getName()
    {
        return name;
    }

    public static Logger getLogger(String name)
    {
        for (Logger l : loggers)
        {
            if (l.name.equals(name))
                return l;
        }
        return new Logger(name);
    }

    //region LogMessage

    public void log(String level, String message)
    {
        String levelUp = level.toUpperCase();
        if (levels.get(levelUp) < levels.get(this.level))
            return;
        boolean correctLevel = false;
        for (String l : levels.keySet())
            if (levelUp.equals(l))
                correctLevel = true;
        if (!correctLevel)
            return;
        Date date = new Date();
        SimpleDateFormat dateF = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.printf("[%s] %s %s - %s", level, dateF.format(date), name, message);
    }

    public void error(String message)
    {
        log("ERROR", message);
    }

    public void warning(String message)
    {
        log("WARNING", message);
    }

    public void info(String message)
    {
        log("INFO", message);
    }

    public void debug(String message)
    {
        log("DEBUG", message);
    }

    //endregion

    //region LogFormattedMessage

    private void log(String level, String format, Object... args)
    {
        String message = String.format(format, args);
        log(level, message);
    }

    public void error(String message, Object... args)
    {
        log("ERROR", message, args);
    }

    public void warning(String message, Object... args)
    {
        log("WARNING", message, args);
    }

    public void info(String message, Object... args)
    {
        log("INFO", message, args);
    }

    public void debug(String message, Object... args)
    {
        log("DEBUG", message, args);
    }

    //endregion

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {

        String levelUp = level.toUpperCase();
        for (String l : levels.keySet())
            if (levelUp.equals(l))
                this.level = levelUp;
    }
}


