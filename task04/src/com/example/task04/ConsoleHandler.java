package com.example.task04;

public class ConsoleHandler implements MessageHandler{

    MyLogger myLogger;

    public ConsoleHandler(){
        this.myLogger = MyLogger.getLogger("ConsoleHandlerLogger");
    }

    @Override
    public void log(Level level, String string) {
        myLogger.log(level, string);
        System.out.println(myLogger.getLogs().get(myLogger.getLogs().size() - 1));
    }
}
