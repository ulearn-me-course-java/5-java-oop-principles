package com.example.task04;

public class MemoryHandler implements MessageHandler{

    MyLogger myLogger;
    MessageHandler mh;


    public MemoryHandler(MessageHandler mh){
        this.myLogger = MyLogger.getLogger("MemoryHandlerLogger");
        this.mh = mh;
    }

    @Override
    public void log(Level level, String string) {
        myLogger.log(level, string);
    }

    public void write() {
        for(Log log : myLogger.getLogs()) {
            mh.log(log.level, log.message);
        }
        myLogger.eraseLogs();
    }
}
