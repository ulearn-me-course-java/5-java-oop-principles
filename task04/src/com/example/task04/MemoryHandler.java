package com.example.task04;

public class MemoryHandler implements MessageHandler{

    Logger logger;
    MessageHandler mh;


    public MemoryHandler(MessageHandler mh){
        this.logger = Logger.getLogger("MemoryHandlerLogger");
        this.mh = mh;
    }

    @Override
    public void log(Level level, String string) {
        logger.log(level, string);
    }

    public void write() {
        for(Log log : logger.getLogs()) {
            mh.log(log.level, log.message);
        }
        logger.eraseLogs();
    }
}
