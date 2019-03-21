
package com.example.task04;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

enum LogLevels {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private LogLevels thisLevel;
    private String name;
    private static int maxLevel = 0; //TODO
    private static ArrayList<Logger> loggerList = new ArrayList<>();
    private static ArrayList<MessageHandler> hndls = new ArrayList<>();

    public Logger(String Name) {
        for (Logger e : loggerList) {
            if (e.name == Name) {
                throw new IllegalArgumentException();
            }
        }

        name = Name;
        loggerList.add(this);
    }

    public void addHandler(MessageHandler hndl){
        if(hndl != null){
            hndls.add(hndl);
        }
    }

    public static Logger getLogger(String Name) {
        for (Logger e : loggerList) {
            if (e.name == Name) {
                return e;
            }
        }

        throw new IllegalArgumentException();
    }

    public String getName() {
        return this.name;
    }

    public LogLevels getLevel() {
        return thisLevel;
    }

    public void setLevel(LogLevels lvl) {
        thisLevel = lvl;

        switch (lvl) {
            case DEBUG:
                maxLevel = 1;
                break;
            case INFO:
                maxLevel = 2;
                break;
            case ERROR:
                maxLevel = 3;
                break;
            case WARNING:
                maxLevel = 4;
                break;
            default:
                break;
        }
    }

    public void log(LogLevels level, String message) {
        log(level, message, null);
    }

    public void log(LogLevels level, String message, Object... vars) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = new Date();

        System.out.println("[" + level + "] " + sdfDate.format(date) + " " + this.name + " - " + String.format(message, vars));
    }

    public void debug(String out) {
        if (maxLevel < 2) {
            maxLevel = 2;
        }
        if (maxLevel == 2) {
            log(LogLevels.DEBUG, out);
        }
    }

    public void debug(String template, Object... vars) {
        if (maxLevel < 2) {
            maxLevel = 2;
        }
        if (maxLevel == 2) {
            log(LogLevels.DEBUG, template, vars);
        }
    }

    public void info(String out) {
        if (maxLevel < 3) {
            maxLevel = 1;
        }
        if (maxLevel == 1) {
            log(LogLevels.INFO, out);
        }
    }

    public void info(String template, Object... vars) {
        if (maxLevel < 3) {
            maxLevel = 1;
        }
        if (maxLevel == 1) {
            log(LogLevels.INFO, template, vars);
        }
    }

    public void warning(String out) {
        if (maxLevel < 3) {
            maxLevel = 3;
        }
        if (maxLevel == 3) {
            log(LogLevels.WARNING, out);
        }
    }

    public void warning(String template, Object... vars) {
        if (maxLevel < 3) {
            maxLevel = 3;
        }
        if (maxLevel == 3) {
            log(LogLevels.WARNING, template, vars);
        }
    }

    public void error(String out) {
        if (maxLevel < 4) {
            maxLevel = 4;
        }
        if (maxLevel == 4) {
            log(LogLevels.ERROR, out);
        }
    }

    public void error(String template, Object... vars) {
        if (maxLevel < 4) {
            maxLevel = 4;
        }
        if (maxLevel == 4) {
            log(LogLevels.ERROR, template, vars);
        }
    }
}