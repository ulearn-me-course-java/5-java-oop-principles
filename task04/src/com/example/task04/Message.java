package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message
{
    private Level level;
    private final String loggerName;

    public Message(Level level, String loggerName)
    {
        this.level = level;
        this.loggerName = loggerName;
    }

    public String getMessage(String inputStr)
    {
        String dateStr = new SimpleDateFormat("y.M.d  H:m:s").format(new Date());
        return String.format("[%s] %s %s - %s", level, dateStr, loggerName, inputStr);
    }

    public String getMessage(String format, Object... variables)
    {
        String str = String.format(format, variables);
        return getMessage(str);
    }

    public void setLevel(Level level)
    {
        this.level = level;
    }
}
