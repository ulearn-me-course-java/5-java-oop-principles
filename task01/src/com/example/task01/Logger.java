package com.example.task01;

import sun.rmi.runtime.Log;

import java.util.ArrayList;

public class Logger {

    enum levels {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
    private String name;
    private static ArrayList<Logger> list = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        list.add(this);
    }

    public String getName() {
        return  name;
    }

    public static Logger getLogger(String name) {
        for(Logger log : list) {
            if ( log.name == name) {
                return log;
            }
        }
        return new Logger(name);
    }
}
